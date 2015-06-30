package im.mange.jetboot.widget.form.layout

import im.mange.jetboot.Css._
import im.mange.jetboot.Html._
import im.mange.jetboot.bootstrap3.Bootstrap._
import im.mange.jetboot.input.CheckBox
import im.mange.jetboot.widget.form.{FieldError, FormInput}
import im.mange.jetboot.{R, Js, Renderable}

trait LayoutElement extends Renderable {
  val columns: Int
}

case class FormGroup(elements: Seq[LayoutElement]) extends Renderable {
  def render = div(elements.toList).classes(formGroup/*, formGroupSm*/).styles(marginBottom("5px")).render
}

case class ControlLabel(columns: Int, label: Renderable) extends LayoutElement {
  def render = <label class={s"control-label col-sm-$columns"} style="font-size: xx-small; color: grey; font-weight: normal;">{label.render}</label>
}

case class RenderableElement(columns: Int, renderable: Renderable) extends LayoutElement {
  def render = div(renderable).classes(s"col-sm-$columns").render
}

case class FormControl(columns: Int, formInput: FormInput) extends LayoutElement {
  import im.mange.jetboot.bootstrap3.Bootstrap._

  def id = s"fc_${formInput.id}"

  private def helpBlock = span(id = Some(s"hb_${formInput.id}"), "")
    .classes("help-block", hidden)
    .styles(fontSize(xSmall))

  //TODO: ICK .. PA needs to fix jetboot class adding
  formInput match {
    case c:CheckBox => //ignore because annoyingly bootstrap formats checkboxes differently to everything-else
    //TODO: pass in the sizing style, so clients can control the sizing
    case _ => formInput.classes = formInput.classes.add(formControl, "input-xs")
  }

  //TODO: pass in the sizing style, so clients can control the sizing
  def render = div(id = Some(id), formInput, helpBlock).classes(s"col-sm-$columns").render

  def onError(error: FieldError) = Js.addElementClass(id, "has-error") & helpBlock.fillAndShow(R(error.message))
  def onSuccess = Js.removeElementClass(id, "has-error") & helpBlock.emptyAndHide
}
