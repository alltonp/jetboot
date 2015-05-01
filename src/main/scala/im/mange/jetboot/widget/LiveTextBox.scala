package im.mange.jetboot.widget

import im.mange.jetboot.Js._
import im.mange.jetboot.{Disableable, Hideable, Input, Styleable}
import net.liftweb.http.SHtml
import net.liftweb.http.js.JE.JsRaw
import net.liftweb.util.Helpers._

@deprecated("Use HtmlInput instead", "01/05/2015")
trait LiveTextBox extends Input with Styleable with Hideable with Disableable {
  val placeholder: String
  val default: String

  def render = SHtml.text(default, (query) ⇒ nothing, "id" → id, "style" → styles.render, "class" → classes.render,
    "placeholder" → placeholder) % ("onkeyup" → SHtml.ajaxCall(JsRaw("this.value"), (query) ⇒ onKeyUp(query) )._2)

  def onKeyUp(value: String): Unit
  def updateValue(value: String) = element.setValue(value)
}
