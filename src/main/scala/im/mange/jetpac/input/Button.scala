package im.mange.jetpac.input

import im.mange.jetpac.{ButtonPresentation, Input}
import net.liftweb.http.SHtml._
import net.liftweb.http.js.JsCmd

case class Button(id: String, buttonPresentation: ButtonPresentation, onClick: () => JsCmd) extends Input {
  def render = ajaxButton(buttonPresentation.renderable.render, onClick, "id" -> id,
    "style" -> buttonPresentation.styles.render,
    "class" -> buttonPresentation.classes.render)
}
