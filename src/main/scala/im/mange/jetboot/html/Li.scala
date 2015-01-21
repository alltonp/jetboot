package im.mange.jetboot.html

import im.mange.jetboot.{Styleable, Renderable}

case class Li(content: Renderable) extends Renderable with Styleable {
  def render = <li class={classes.render} style={styles.render}>{content.render}</li>
}
