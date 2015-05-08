package im.mange.jetboot.html

import im.mange.jetboot._

//TODO: I should have minimum show/hide, fill/empty
//TODO: I dont think I should be a case class actually - maybe be trait or abstract class with an Object
//TODO: if we stopped this being a Widget and Hideable, then id would no longer need to be mandatory
//TODO: show be fillable like a div?
case class Span(id: String, content: Renderable) extends /*Widget with*/ Hideable with Fillable with Styleable with HtmlElement {
  def render = <span id={id} class={classes.render} style={styles.render} title={title}>{content.render}</span>
}
