package im.mange.jetpac

import net.liftweb.http.SHtml

import scala.xml.Elem

object Attributify {
  import net.liftweb.http.SHtml.ElemAttr

  def apply(elem: Elem, allAttributes: Seq[(String, String)]) = {
    val elemAttrs: Seq[SHtml.ElemAttr] = ElemAttr.strSeqToElemAttr(cleanse(allAttributes))
    elemAttrs.foldLeft(elem)(_ % _)
  }

  private def cleanse(attributes: Seq[(String, String)]) = attributes.filterNot(a => a._2.isEmpty)
}
