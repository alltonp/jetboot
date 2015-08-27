package im.mange.jetpac.input

import im.mange.jetboot.widget.form.FormInput
import im.mange.jetpac.{Js, Event}
import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmd

case class TextBox(field: Field, placeholder: Option[String], default: Option[String]) extends FormInput {
  var value = safeDefault

  private def safeDefault = default getOrElse ""

  def baseElement = SHtml.text(value, onSubmit, "id" → id, "style" → styles.render, "class" → classes.render,
    "placeholder" → placeholder.getOrElse(""))

  private def onSubmit(value: String) { this.value = value }

  def onChange(handler: String => JsCmd): this.type = addEvents(Event.onChange -> handler)
  def onKeyUp(handler: String => JsCmd): this.type = addEvents(Event.onKeyUp -> handler)

  override def reset = Js.setElementValue(id, safeDefault)
}