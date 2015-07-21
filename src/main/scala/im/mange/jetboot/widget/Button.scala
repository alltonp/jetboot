package im.mange.jetboot.widget

import im.mange.jetboot.{Input, Hideable}
import net.liftweb.http.SHtml._
import net.liftweb.http.js.JsCmd

//TODO: should this be Styleable? - think no actually because of ButtonPresentation .. but that could be bogus
@deprecated("Use HtmlInput instead", "01/05/2015")
trait Button extends Input with Hideable {
  def presentation: ButtonPresentation
  def onClick: JsCmd
}

//TODO: support "data-toggle" → "button"
@deprecated("Use HtmlInput instead", "01/05/2015")
trait ClientSideButton extends Button {
  //TODO: we do this in a few places .. id, class, style etc
  def render = a(presentation.body, onClick, "id" → id, "style" → presentation.styles.render, "class" → presentation.classes.render)
}

//TODO: support "data-toggle" → "button"
@deprecated("Use HtmlInput instead", "01/05/2015")
trait ServerSideButton extends Button {
  //TODO: we do this in a few places .. id, class, style etc
  def render = a(() ⇒ onClick, presentation.body, "id" → id, "style" → presentation.styles.render, "class" → presentation.classes.render)
}

@deprecated("Use HtmlInput instead", "01/05/2015")
trait LinkButton extends Button {
  import im.mange.jetboot.Js._

  //TODO: target should be configurable
  def url: String
  val onClick = nothing
  def render = <a href={url} id={id} target="_blank" class={presentation.classes.render} style={presentation.styles.render}>{presentation.body}</a>
}


