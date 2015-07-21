package im.mange.jetboot.html

import im.mange.jetboot.{Styleable, Renderable}
import net.liftweb.{json, http, util, common}
import net.liftweb.http.{S, SHtml}
import net.liftweb.http.SHtml._
import net.liftweb.http.js.{JsCmds, JE, JsCmd}

case class A(id: String, content: Renderable, onClick: () => JsCmd, ajax: Boolean) extends Renderable with Styleable {
  def render = {
    val attributes: Seq[(String, String)] = Map("id" → id, "style" → styles.render, "class" → classes.render).toSeq
    val elemAttrs = ElemAttr.strSeqToElemAttr(attributes)
    if (ajax) a(onClick, content.render, elemAttrs:_*)
    //TODO: need to check this actually does the right thing ...
    else a(content.render, onClick(), elemAttrs:_*)
  }
}

case class LinkAnchor(id: String, url: String, content: Renderable, target: Option[String]) extends Renderable with Styleable {
  def render = <a href={url} id={id} target={target.getOrElse("")} class={classes.render} style={styles.render}>{content}</a>
}
