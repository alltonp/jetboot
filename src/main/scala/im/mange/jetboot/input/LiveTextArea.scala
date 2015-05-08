package im.mange.jetboot.input

import im.mange.jetboot.Event
import im.mange.jetboot.widget.form.FormInput
import net.liftweb.http.js.JsCmd
import net.liftweb.http.SHtml
import net.liftweb.util.Helpers._

case class LiveTextArea(field: Field, placeholder: String, default: String) extends FormInput {
  var value = default

  def baseElement =
    SHtml.textarea(default, onSubmit, "id" → id, "style" → styles.render, "class" → classes.render, "placeholder" → placeholder)
  
  private def onSubmit(value: String) { this.value = value }

  def onKeyUp(handler: String => JsCmd) = addEvents(Event.onKeyUp -> handler)
}
