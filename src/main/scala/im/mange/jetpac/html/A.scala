package im.mange.jetpac.html

import im.mange.jetboot.{HasAttributes, Styleable, Renderable}
import net.liftweb.{json, http, util, common}
import net.liftweb.http.{S, SHtml}
import net.liftweb.http.SHtml._
import net.liftweb.http.js.{JsCmds, JE, JsCmd}

case class A(id: String, content: Renderable, onClick: () => JsCmd, ajax: Boolean) extends Renderable with Styleable with HasAttributes {
  def render = {
    //TODO: put this stuff in to WithAttirbutes and make Styleable extend that somehow
    val allAttributes: Seq[(String, String)] = Map("id" → id, "style" → styles.render, "class" → classes.render).toSeq ++ attributes.toSeq
    val elemAttrs = ElemAttr.strSeqToElemAttr(allAttributes)
    if (ajax) a(onClick, content.render, elemAttrs:_*)
    //TODO: need to check this actually does the right thing ...
    else a(content.render, onClick(), elemAttrs:_*)
  }
}

case class LinkAnchor(id: String, url: String, content: Renderable, target: Option[String]) extends Renderable with Styleable {
  def render = <a href={url} id={id} target={target.getOrElse("")} class={classes.render} style={styles.render}>{content.render}</a>
}


