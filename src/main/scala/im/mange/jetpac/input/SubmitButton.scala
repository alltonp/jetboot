package im.mange.jetpac.input

import im.mange.jetpac.{ButtonPresentation, Styleable, Input}
import net.liftweb.http.SHtml._
import net.liftweb.http.js.JsCmd

case class SubmitButton(id: String, value: String, onSubmit: () => JsCmd) extends Input with Styleable {
  def render = ajaxSubmit(value, onSubmit, "id" -> id, "style" -> styles.render, "class" -> classes.render)
}
