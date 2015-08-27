package im.mange.jetboot.widget.form.layout

import im.mange.jetboot._
import im.mange.jetboot.bootstrap3.Bootstrap._
import im.mange.jetpac._
import im.mange.jetpac.input.Field
import im.mange.jetboot.widget.SimpleForm
import im.mange.jetboot.widget.form.FieldError
import net.liftweb.http.js.JsCmds.Script

case class FormLayout(id: String, private val groups: Seq[FormGroup], prefixIdsWithParent: Boolean) extends Renderable with Clearable with Resettable with Focusable with Disableable {
  private val controls = groups.flatMap(_.elements).flatMap {
    case f: FormControl => Some(f)
    case _ => None
  }

  //TODO: find a nicer way to do this
  controls.map(c => {
    if (prefixIdsWithParent) c.formInput.field.parent = Some(id)
    c.formInput
  })

  val form = SimpleForm.simpleForm(id, controls.map(_.formInput ))

  //TODO: colour the label too? label - #A94442; normally grey ....
  //TODO: pass in error class?
  //TODO: don't dick with other's id - delegate the Js to FormControl
  //TODO: I need a better name to reflect the intention
  def errors(errors: Seq[FieldError]) = {
    Js.chain(controls.map(fc => {
    errors.find(e => fc.formInput.field.id == Field(e.fieldName, Some(id)).id) match {
        case Some(fe) => fc.onError(fe)
        case None => fc.onSuccess
      }
    })) & focusFirst(errors)
  }

  private def focusFirst(errors: Seq[FieldError]) = errors.headOption.fold(Js.nothing)(fe =>
    controls.find(c => c.formInput.field.name == fe.fieldName).fold(Js.nothing)(_.formInput.focus))

  override def focus = form.focus
  override def clear = errors(Nil) & form.clear & form.enable & focus
  override def reset = errors(Nil) & form.reset & form.enable & focus
  override def disable = form.disable

  def render = {
    import Html._

    div(
      R(<form id={form.id} class="lift:form.ajax">
        <div class="form-horizontal">
          {R(groups).render}
        </div>
      </form>
      )
    )
    .classes(containerFluid)
    .render ++ Script(form.init)
  }
}
