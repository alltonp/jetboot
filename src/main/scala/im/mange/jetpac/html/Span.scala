package im.mange.jetpac.html

import im.mange.jetpac._
import net.liftweb.http.SHtml.ElemAttr

//TODO: Hmm ... id should be an Option ... things that depend on id e.g. Fillable etc should do Js.nothing on a None
case class Span(id: String, content: Renderable) extends Hideable with Fillable with HideableAndFillable with Styleable with HasAttributes with Renderable {
  def render = {
    val allAttributes: Seq[(String, String)] = Map("id" → id, "style" → styles.render, "class" → classes.render).toSeq ++ attributes.toSeq
    val elemAttrs = ElemAttr.strSeqToElemAttr(allAttributes)
    val base = <span>{content.render}</span>
    elemAttrs.foldLeft(base)(_ % _)
  }
}
