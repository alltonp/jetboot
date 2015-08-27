package im.mange.jetpac.html

import im.mange.jetboot.{Styleable, Renderable}

case class Ul(content: Renderable) extends Renderable with Styleable {
  def render = <ul class={classes.render} style={styles.render}>{content.render}</ul>
}
