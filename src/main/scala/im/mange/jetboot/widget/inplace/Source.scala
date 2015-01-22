package im.mange.jetboot.widget.inplace

import net.liftweb.http.js.JE.{JsArray, JsObj}

case class Source(values: List[String]) {
  def toJsArray = JsArray(values.map(v ⇒ JsObj(("value", v), ("text", v))))
}
