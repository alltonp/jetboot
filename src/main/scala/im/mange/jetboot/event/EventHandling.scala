package im.mange.jetboot.event

import net.liftweb.http.SHtml
import net.liftweb.http.js.JE.JsRaw
import net.liftweb.http.js.{JsCmd, JsExp}
import net.liftweb.util.Helpers._

import scala.xml.Elem

trait EventHandling {
  protected var eventHandlers: Seq[EventHandler] = Nil

  //TODO: this needs to die
  def render = eventHandlers.foldLeft(baseElement)((acc, handler) => acc % handler.toAjax)

  def addEvents(handlers: (String, (String) => JsCmd)*): this.type =
  { eventHandlers ++= handlers.map { case (eventType, handler) => EventHandler(eventType, handler)}; this }

  def attachHandlersToBase(base: Elem) = eventHandlers.foldLeft(base)((acc, handler) => acc % handler.toAjax)

  //TODO: this needs to die too
  def baseElement: Elem
}

case class EventHandler(eventType: String, handler: (String) => JsCmd, dataCapturer: JsExp = JsRaw("this.value")) {
  def toAjax: (String, JsExp) = eventType -> SHtml.ajaxCall(dataCapturer, handler)._2
}
