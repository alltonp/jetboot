package im.mange.jetpac

//TODO: should this be styleable (are all html elements styleable?ask w3c) and identifiable (only if id is an Option for the latter)
//TODO: this can probably die, now that we have HideableAndFillable
trait HtmlElement extends Renderable {
  var title: String = ""

  def title(t: String): this.type = {title = t; this}
}
