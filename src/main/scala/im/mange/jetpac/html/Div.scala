package im.mange.jetpac.html

import im.mange.jetpac._

//TODO: for fill() to work we need a proper div, need to think about that a bit
//TODO: Hmm ... id should be an Option ... things that depend on id e.g. Fillable etc should do Js.nothing on a None
case class Div(id: String, content: Renderable) extends Hideable with Fillable with HideableAndFillable with Styleable with HasAttributes with Renderable {
  def render = {
    val allAttributes = Map("id" → id, "style" → styles.render, "class" → classes.render).toSeq ++ attributes.toSeq
    Attributify(<div>{content.render}</div>, allAttributes)
  }
}


