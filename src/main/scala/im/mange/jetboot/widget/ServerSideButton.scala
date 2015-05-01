package im.mange.jetboot.widget

import net.liftweb.http.SHtml._

//TODO: support "data-toggle" → "button"
@deprecated("Use HtmlInput instead", "01/05/2015")
trait ServerSideButton extends Button {
  //TODO: we do this in a few places .. id, class, style etc
  def render = a(() ⇒ onClick, presentation.body, "id" → id, "style" → presentation.styles.render, "class" → presentation.classes.render)
}
