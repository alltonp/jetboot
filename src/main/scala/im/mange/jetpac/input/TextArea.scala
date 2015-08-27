package im.mange.jetpac.input

import im.mange.jetboot.widget.form.FormInput
import im.mange.jetpac.Js
import net.liftweb.http.SHtml

case class TextArea(field: Field, placeholder: String, default: String) extends FormInput {
  var value = default

  def baseElement = SHtml.textarea("", onSubmit, "id" → id, "style" → styles.render, "class" → classes.render, "placeholder" → placeholder)

  private def onSubmit(value: String) { this.value = value }

  override def reset = Js.setElementValue(id, default)
}
