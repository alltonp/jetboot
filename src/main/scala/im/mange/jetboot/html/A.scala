package im.mange.jetboot.html

import im.mange.jetboot.{Styleable, Renderable}
import net.liftweb.http.SHtml._
import net.liftweb.http.js.JsCmd

case class ClientSideAnchor(id: String, content: Renderable, onClick: JsCmd) extends Renderable with Styleable {
  def render = a(content.render, onClick, "id" → id, "style" → styles.render, "class" → classes.render)
}

case class ServerSideAnchor(id: String, content: Renderable, onClick: JsCmd) extends Renderable with Styleable {
  def render = a(() ⇒ onClick, content.render, "id" → id, "style" → styles.render, "class" → classes.render)
}

case class LinkAnchor(id: String, url: String, content: Renderable, target: Option[String]) extends Renderable with Styleable {
  def render = <a href={url} id={id} target={target.getOrElse("")} class={classes.render} style={styles.render}>{content}</a>
}
