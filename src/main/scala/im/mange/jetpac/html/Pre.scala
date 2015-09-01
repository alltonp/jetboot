package im.mange.jetpac.html

import im.mange.jetpac.{Styleable, Renderable}

case class Pre(content: Renderable) extends Renderable with Styleable {
  def render = <pre class={classes.render} style={styles.render}>{content.render}</pre>
}
