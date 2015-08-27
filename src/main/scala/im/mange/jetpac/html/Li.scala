package im.mange.jetpac.html

import im.mange.jetpac.{HasAttributes, Renderable, Styleable}
import net.liftweb.http.SHtml.ElemAttr

//TIP: this is the model for all future Elements ...
//TODO: make base be the smallest possible .. i.e remove class and style
case class Li(content: Renderable) extends Renderable with Styleable with HasAttributes {
  def render = {
    val allAttributes: Seq[(String, String)] = Map("style" → styles.render, "class" → classes.render).toSeq ++ attributes.toSeq
    val elemAttrs = ElemAttr.strSeqToElemAttr(allAttributes)
    //TODO: base can be made simpler
    val base = <li class={classes.render} style={styles.render}>{content.render}</li>
    elemAttrs.foldLeft(base)(_ % _)
  }
}
