package im.mange.jetpac.html

import im.mange.jetpac.event.EventHandling
import im.mange.jetpac._
import net.liftweb.http.js.JsCmd
import net.liftweb.http.SHtml.ElemAttr


//TODO: okay, theses are definitely all Elements

case class Th(content: Renderable) extends Renderable with Styleable with HasAttributes {
  def render = {
    val allAttributes = Map("style" → styles.render, "class" → classes.render).toSeq ++ attributes.toSeq
    Attributify(<th>{content.render}</th>, allAttributes)
  }
}

case class Td(content: Renderable) extends Renderable with Styleable with HasAttributes {
  def render = {
    val allAttributes = Map("style" → styles.render, "class" → classes.render).toSeq ++ attributes.toSeq
    Attributify(<td>{content.render}</td>, allAttributes)
  }
}

case class Tr(id: Option[String] ,content: Renderable) extends Renderable with Styleable with HasAttributes with EventHandling {
  def baseElement = {
    val allAttributes = Map("id" -> id.getOrElse(""), "style" → styles.render, "class" → classes.render).toSeq ++ attributes.toSeq
    Attributify(<tr>{content.render}</tr>, allAttributes)
  }

  def onClick(handler: String => JsCmd): this.type = addEvents(Event.onClick -> handler)
}

case class Tbody(content: Renderable) extends Renderable with Styleable with HasAttributes {
  def render = {
    val allAttributes = Map("style" → styles.render, "class" → classes.render).toSeq ++ attributes.toSeq
    Attributify(<tbody>{content.render}</tbody>, allAttributes)
  }
}

case class Thead(content: Renderable) extends Renderable with Styleable with HasAttributes{
  def render = {
    val allAttributes = Map("style" → styles.render, "class" → classes.render).toSeq ++ attributes.toSeq
    Attributify(<thead>{content.render}</thead>, allAttributes)
  }
}

case class Table(thead: Thead, tbody: Tbody) extends Renderable with Styleable with HasAttributes {
  def render = {
    val allAttributes = Map("style" → styles.render, "class" → classes.render).toSeq ++ attributes.toSeq
    Attributify(<table>{thead.render}{tbody.render}</table>, allAttributes)
  }
}