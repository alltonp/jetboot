package im.mange.jetboot.input

import im.mange.jetboot.{Input, Styleable}
import net.liftweb.http.SHtml._
import net.liftweb.http.js.JsCmd

case class SubmitButton(id: String, value: String, onSubmit: () => JsCmd) extends Input with Styleable {
  def render = ajaxSubmit(value, onSubmit, "id" -> id, "style" -> styles.render, "class" -> classes.render)
}


