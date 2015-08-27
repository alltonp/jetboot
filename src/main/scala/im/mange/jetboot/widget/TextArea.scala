package im.mange.jetboot.widget

import im.mange.jetpac.{Styleable, Renderable, Hideable, Disableable}
import net.liftweb.http.SHtml

//TODO: this should probably extend Input
@deprecated("Use HtmlInput instead", "01/05/2015")
trait TextArea extends Renderable with Styleable with Disableable with Hideable {
  val placeholder: String
  def render = SHtml.textarea("", onSubmit(_), "id" → id, "class" → classes.render, "placeholder" → placeholder)
  def updateValue(value: String) = element.setValue(value)
  def onSubmit(value: String): Unit
}
