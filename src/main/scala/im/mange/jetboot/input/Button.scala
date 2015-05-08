package im.mange.jetboot.input

import im.mange.jetboot.{Input, Styleable}
import net.liftweb.http.SHtml._
import net.liftweb.http.js.JsCmd

case class Button(id: String, value: String, onClick: () => JsCmd) extends Input with Styleable {
  def render = ajaxButton(value, onClick, "id" -> id, "style" -> styles.render, "class" -> classes.render)
}
