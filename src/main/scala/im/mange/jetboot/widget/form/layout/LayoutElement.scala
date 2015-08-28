package im.mange.jetboot.widget.form.layout

import im.mange.jetboot.Bss
import im.mange.jetpac._
import Bss._
import im.mange.jetpac.input.CheckBox
import im.mange.jetboot.widget.form.{FieldError, FormInput}

trait LayoutElement extends Renderable {
  val columns: Int
}

case class FormGroup(elements: Seq[LayoutElement]) extends Renderable {
  def render = div(elements:_*).classes(formGroup/*, formGroupSm*/).styles(marginBottom("5px")).render
}

case class ControlLabel(columns: Int, label: Renderable) extends LayoutElement {
  def render = <label class={s"control-label col-sm-$columns"} style="font-size: xx-small; color: grey; font-weight: normal;">{label.render}</label>
}

case class RenderableElement(columns: Int, renderable: Renderable) extends LayoutElement {
  def render = div(renderable).classes(s"col-sm-$columns").render
}

case class FormControl(columns: Int, formInput: FormInput) extends LayoutElement {
  import Bss._

  def id = s"fc_${formInput.id}"

  //TODO: this looks like it should be a val .. but it seems it can't be ...
  private def inputHelpBlock = span(id = Some(s"hb_${formInput.id}"), "")
    .classes(helpBlock, hidden)
    .styles(fontSize(xSmall))

  //TODO: ICK .. PA needs to fix jetboot class adding
  formInput match {
    case c:CheckBox => //ignore because annoyingly bootstrap formats checkboxes differently to everything-else
    //TODO: pass in the sizing style, so clients can control the sizing
    case _ => formInput.classes = formInput.classes.add(formControl, "input-xs")
  }

  //TODO: pass in the sizing style, so clients can control the sizing
  def render = div(id = Some(id), formInput, inputHelpBlock).classes(s"col-sm-$columns").render

  def onError(error: FieldError) = Js.addElementClass(id, hasError) & inputHelpBlock.fillAndShow(R(error.message))
  def onSuccess = Js.removeElementClass(id, hasError) & inputHelpBlock.emptyAndHide
}
