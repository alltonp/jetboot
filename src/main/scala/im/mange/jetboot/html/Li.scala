package im.mange.jetboot.html

import im.mange.jetboot.{HasAttributes, Styleable, Renderable}
import net.liftweb.http.S._
import net.liftweb.http.SHtml.ElemAttr
import net.liftweb.http.js.JE.Str

case class Li(content: Renderable) extends Renderable with Styleable with HasAttributes {
  def render = {
    val allAttributes: Seq[(String, String)] = Map("style" → styles.render, "class" → classes.render).toSeq ++ attributes.toSeq
    val elemAttrs = ElemAttr.strSeqToElemAttr(allAttributes)
    //TODO: base can be made simpler
    val base = <li class={classes.render} style={styles.render}>{content.render}</li>
    elemAttrs.foldLeft(base)(_ % _)
  }
}
