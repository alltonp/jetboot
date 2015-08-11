package im.mange.jetboot

import net.liftweb.http.js.JsCmd

@deprecated("Use HtmlInput instead", "01/05/2015")
trait Select extends Input with Hideable with Styleable {
  //TODO: this should be an Option me thinks and mapped to a Lift Box
  def default: String
  def options: Seq[(String, String)]
  def onChange(newValue: String): JsCmd
}
