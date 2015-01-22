package im.mange.jetboot.widget

import im.mange.jetboot._
import im.mange.jetboot.js.JsCmdFactory._
import net.liftweb.http.SHtml
import net.liftweb.http.js.JE.JsRaw
import net.liftweb.util.Helpers._

trait TextBox extends Renderable with Styleable with Disableable with Hideable {
  val placeholder: String

  def render = SHtml.text("", (query) ⇒ nothing, "id" → id, "style" → styles.render, "class" → classes.render,
    "placeholder" → placeholder) % ("onkeyup" → SHtml.ajaxCall(JsRaw("this.value"), (query) ⇒ onKeyUp(query) )._2)

  //TODO: re-enable once we know this works
//  def updateValue(value: String) = element.setValue(value)
  def onKeyUp(value: String): Unit
}
