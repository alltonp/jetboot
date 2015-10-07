package im.mange.jetpac

import net.liftweb.http.SHtml

import scala.xml.Elem

object Attributify {
  import net.liftweb.http.SHtml.ElemAttr

  def apply(elem: Elem, allAttributes: Seq[(String, String)]) = {
    val elemAttrs: Seq[SHtml.ElemAttr] = ElemAttr.strSeqToElemAttr(allAttributes)
    elemAttrs.foldLeft(elem)(_ % _)
  }
}
