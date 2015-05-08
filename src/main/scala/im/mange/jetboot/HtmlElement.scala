package im.mange.jetboot

//TODO: should this be styleable (are all html elements styleable?ask w3c) and identifiable (only if id is an Option for the latter)
trait HtmlElement extends Renderable {
  var title: String = ""

  def title(t: String): this.type = {title = t; this}
}
