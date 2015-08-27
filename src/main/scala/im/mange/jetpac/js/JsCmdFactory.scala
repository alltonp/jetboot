package im.mange.jetpac.js

import im.mange.jetpac.Js
import net.liftweb.http.js.JE.{JsRaw, ValById}
import net.liftweb.http.js.JsCmds.{SetHtml, _}
import net.liftweb.http.js.jquery.JqJE.{JqAttr, JqGetAttr, JqId, JqPrepend, JqRemove, JqReplace, _}
import net.liftweb.http.js.{JsCmd, JsExp, JsMember}

import scala.xml.NodeSeq

trait JsCmdFactory {
  def showElement(id: String): JsCmd = JqId(id) ~> JqShow()
  def showAllElements(cssClass: String): JsCmd = JqClass(cssClass) ~> JqShow()
  def toggleAllElements(cssClass: String): JsCmd = JqClass(cssClass) ~> JqToggle()
  def hideElement(id: String): JsCmd = JqId(id) ~> JqHide()
  def hideAllElements(cssClass: String): JsCmd = JqClass(cssClass) ~> JqHide()
  def disableElement(id: String): JsCmd = JqId(id) ~> JqAttr("disabled", true)
  def enableElement(id: String): JsCmd = JqId(id) ~> JqAttr("disabled", false)
  def focusElement(id: String): JsCmd = Focus(id)
  //TODO: go after usages of this and use fill instead
  def replaceElement(id: String, content: NodeSeq): JsCmd = JqId(id) ~> JqReplace(content)
  def removeElement(id: String): JsCmd = JqId(id) ~> JqRemove()
  def removeAllElements(cssClass: String): JsCmd = JqClass(cssClass) ~> JqRemove()
  def removeElementClass(id: String, attr: String): JsCmd = JqId(id) ~> JqRemoveClass(attr)
  def removeElementAttribute(id: String, attr: String): JsCmd = JqId(id) ~> JqRemoveAttr(attr)
  def addElementClass(id: String, className: String): JsCmd = JqId(id) ~> JqAddClass(className)
  def insertAfter(id: String, content: NodeSeq): JsCmd = JqId(id) ~> JqAfter(content)
  def prependElement(id: String, content: NodeSeq): JsCmd = JqId(id) ~> JqPrepend(content)
  def appendElement(id: String, content: NodeSeq): JsCmd = JqId(id) ~> JqAppend(content)
  def getElementValue(id: String) = ValById(id)
  def getAttributeValue(id: String, attribute: String): JsCmd = JqId(id) ~> JqGetAttr("value")
  def getElementText(id: String) = JqId(id) ~> JqText()
  //  def setElementText(id: String, value: String): JsCmd = JqId(id) ~> JqText(value)
  //  def setElementText(id: String, value: NodeSeq): JsCmd = JqId(id) ~> JqHtml(value) - works
  def setAttributeValue(id: String, attribute: String, value: String): JsCmd = JqId(id) ~> JqAttr(attribute, value)
//  def setElementValue(id: String, value: String): JsCmd = JqId(id) ~> JqAttr("value", value)
  def setElementValue(id: String, value: String): JsCmd = JsRaw("$('#" + id + "').val('" + value + "');")
  def setHrefValue(id: String, value: String): JsCmd = JqId(id) ~> JqAttr("href", value)
  def clearElementValue(id: String): JsCmd = setElementValue(id, "")
  def emptyElement(id: String): JsCmd = JqId(id) ~> JqText("")
  def emptyAndHideElement(id: String): JsCmd = emptyElement(id) & hideElement(id)
  def fillElement(id: String, content: NodeSeq): JsCmd = SetHtml(id, content)
  def fillAndShowElement(id: String, content: NodeSeq): JsCmd = fillElement(id, content) & showElement(id)
  def nothing: JsCmd = Noop
  def reload: JsCmd = Reload
  def chain(jsCmds: Seq[JsCmd]) = jsCmds.foldLeft(Js.nothing){(acc, j) => acc & j}
}

case class JqAfter(content: NodeSeq) extends JsExp with JsMember {
  override val toJsCmd = "after(" + fixHtmlFunc("inline", content) { str ⇒ str } + ")"
}

case class JqShow() extends JsExp with JsMember {
  override val toJsCmd = "removeClass('hidden')"
}

case class JqHide() extends JsExp with JsMember {
  override val toJsCmd = "addClass('hidden')"
}

case class JqToggle() extends JsExp with JsMember {
  override val toJsCmd = "toggle()"
}

case class JqClass(className: JsExp) extends JsExp with JsMember {
  override def toJsCmd = "jQuery('.'+" + className.toJsCmd + ")"
}

case class JqRemoveClass(c: String) extends JsExp with JsMember {
  override val toJsCmd = "removeClass('" + c + "')"
}

case class JqAddClass(c: String) extends JsExp with JsMember {
  override val toJsCmd = "addClass('" + c + "')"
}

case class JqRemoveAttr(c: String) extends JsExp with JsMember {
  override val toJsCmd = "removeAttr('" + c + "')"
}

