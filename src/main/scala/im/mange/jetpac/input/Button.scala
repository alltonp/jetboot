package im.mange.jetpac.input

import im.mange.jetpac.{ButtonPresentation, Styleable, Input}
import net.liftweb.http.SHtml._
import net.liftweb.http.js.JsCmd

//TODO: Styleable must die here ...
case class Button(id: String, buttonPresentation: ButtonPresentation, onClick: () => JsCmd) extends Input with Styleable {
  def render = ajaxButton(buttonPresentation.renderable.render, onClick, "id" -> id,
    "style" -> buttonPresentation.styles.add(styles.styles:_*).render,
    "class" -> buttonPresentation.classes.add(classes.classNames:_*).render)
}
