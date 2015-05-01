package im.mange.jetboot.widget

import im.mange.jetboot.Select
import net.liftweb.common.Full
import net.liftweb.http.SHtml

@deprecated("Use HtmlInput instead", "01/05/2015")
trait ServerSideSelect extends Select {
  def render = SHtml.ajaxSelect(options.toSeq, Full(default), (newValue) ⇒ onChange(newValue),
                                "id" → id, "style" → styles.render, "class" → classes.render)
}