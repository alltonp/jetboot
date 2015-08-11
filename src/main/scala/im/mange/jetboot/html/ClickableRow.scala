package im.mange.jetboot.html

import im.mange.jetboot.{R, Renderable, Styleable}
import net.liftweb.http.SHtml.ajaxInvoke
import net.liftweb.http.js.JsCmd

case class ClickableRow(id: Option[String], onClick: () ⇒ JsCmd, cells: Renderable*) extends Renderable with Styleable {
  def render = <tr id={id.getOrElse("")} class={classes.render} style={styles.render} onclick={ajaxInvoke(onClick).toJsCmd}>{R(cells).render}</tr>
}
