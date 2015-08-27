package im.mange.jetpac.html

import im.mange.jetboot._
import im.mange.jetpac._
import net.liftweb.http.SHtml.ElemAttr

//TODO: for fill() to work we need a proper div, need to think about that a bit
//TODO: I dont think I should be a case class actually - maybe be trait or abstract class with an Object
//TODO: er ... arent these Elements actually ... and Widgets are more highlevel - yes I should be in jetboot.html.element or something
//TODO: SimpleWidgets could mixin all the Bootstrap style, StyleKeys and StyleVals stuff for ease of typing/conversion (StyleFactory)
//TODO: maybe have a LayoutFactory to match

//Hmm ... id should be an Option ... things that depend on id e.g. Fillable etc should do Js.nothing on a None
case class Div(id: String, content: Renderable) extends Hideable with Fillable with HideableAndFillable with Styleable with HtmlElement with HasAttributes {
  def render = {
    val allAttributes: Seq[(String, String)] = Map("id" → id, "style" → styles.render, "class" → classes.render).toSeq ++ attributes.toSeq
    val elemAttrs = ElemAttr.strSeqToElemAttr(allAttributes)
    //TODO: base can be made simpler
    val base = <div id={id} class={classes.render} style={styles.render} title={title}>{content.render}</div>
    elemAttrs.foldLeft(base)(_ % _)
  }
}


