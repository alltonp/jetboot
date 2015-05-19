package im.mange.jetboot.input

import im.mange.jetboot.widget.form.FormInput
import im.mange.jetboot.{Event, Js}
import net.liftweb.common.Full
import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmd
import net.liftweb.util.Helpers._

case class Select(field: Field, options: Seq[(String,String)], placeholder: String, defaultValue: Option[String]) extends FormInput {
  var value = safeDefault

  private def safeDefault = defaultValue getOrElse ""

  def baseElement =
    SHtml.select(options, Full(value), onSubmit, "id" → id, "style" → styles.render, "class" → classes.render, "placeholder" → placeholder)

  private def onSubmit(value: String) { this.value = value }

  def onChange(handler: (String) => JsCmd) = addEvents(Event.onChange -> handler)

  override def reset = Js.setElementValue(id, safeDefault)
}
