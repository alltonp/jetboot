package im.mange.jetpac.html

import im.mange.jetpac.{Attributify, HasAttributes, Renderable, Styleable}
import net.liftweb.http.SHtml.ElemAttr

//TIP: this is the model for all future Elements ...
//TODO: make base be the smallest possible .. i.e remove class and style
case class Li(content: Renderable) extends Renderable with Styleable with HasAttributes {
  def render = {
    val allAttributes = Map("style" → styles.render, "class" → classes.render).toSeq ++ attributes.toSeq
    Attributify(<li>{content.render}</li>, allAttributes)
  }
}
