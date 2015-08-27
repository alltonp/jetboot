package im.mange.jetpac.input

import im.mange.jetboot.widget.form.FormInput
import im.mange.jetpac.{Js, Event}
import net.liftweb.http.js.JsCmd
import net.liftweb.http.SHtml
import net.liftweb.util.Helpers._

@deprecated("Use TextBox instead", "01/05/2015")
case class LiveTextBox(field: Field, placeholder: String, default: String) extends FormInput {
  var value = default

  def baseElement =
    SHtml.text(default, onSubmit, "id" → id, "style" → styles.render, "class" → classes.render, "placeholder" → placeholder)

  private def onSubmit(value: String) { this.value = value }

  def onKeyUp(handler: String => JsCmd) = addEvents(Event.onKeyUp -> handler)

  override def reset = Js.setElementValue(id, default)
}