package im.mange.jetpac.html

import im.mange.jetpac.{HasAttributes, Renderable, Styleable}
import net.liftweb.http.SHtml
import net.liftweb.http.SHtml.ElemAttr

import scala.xml.Elem

//TIP: this is the model for all future Elements ...
//TODO: make base be the smallest possible .. i.e remove class and style
case class I(content: Renderable) extends Renderable with Styleable with HasAttributes {
  def render = {
    val allAttributes: Seq[(String, String)] = Map("style" → styles.render, "class" → classes.render).toSeq ++ attributes.toSeq
    Attributify(<i>{content.render}</i>, allAttributes)
  }
}

object Attributify {
  import net.liftweb.http.SHtml.ElemAttr

  def apply(elem: Elem, allAttributes: Seq[(String, String)]) = {
    val elemAttrs: Seq[SHtml.ElemAttr] = ElemAttr.strSeqToElemAttr(allAttributes)
    elemAttrs.foldLeft(elem)(_ % _)
  }
}
