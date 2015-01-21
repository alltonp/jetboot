package im.mange.jetboot

//TODO: should this be styleable and identifiable
trait HtmlElement extends Renderable {
  var title: String = ""

  def title(t: String): this.type = {title = t; this}
}
