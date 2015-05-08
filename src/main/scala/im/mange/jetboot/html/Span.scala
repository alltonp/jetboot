package im.mange.jetboot.html

import im.mange.jetboot._

//TODO: I dont think I should be a case class actually - maybe be trait or abstract class with an Object
//TODO: if we stopped this being a Widget and Hideable, then id would no longer need to be mandatory

//Hmm ... id should be an Option ... things that depend on id e.g. Fillable etc should do Js.nothing on a None
case class Span(id: String, content: Renderable) extends Hideable with Fillable with Styleable with HtmlElement {
  def render = <span id={id} class={classes.render} style={styles.render} title={title}>{content.render}</span>
}
