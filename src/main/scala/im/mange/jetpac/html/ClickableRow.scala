package im.mange.jetpac.html

import im.mange.jetpac.{Styleable, Renderable, R}
import net.liftweb.http.SHtml.ajaxInvoke
import net.liftweb.http.js.JsCmd

//TODO: ultimately Tr or ClickableTr
//TODO: do the style in the same way as the inputs onClick etc ...
@deprecated("Use Tr instead", "28/08/2015")
case class ClickableRow(id: Option[String], onClick: () ⇒ JsCmd, cells: Renderable*) extends Renderable with Styleable {
  def render = <tr id={id.getOrElse("")} class={classes.render} style={styles.render} onclick={ajaxInvoke(onClick).toJsCmd}>{R(cells).render}</tr>
}
