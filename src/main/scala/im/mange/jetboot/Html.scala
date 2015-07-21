package im.mange.jetboot

import im.mange.jetboot.html._
import net.liftweb.http.js.JsCmd

object Html {
  def a(id: String, content: Renderable, onClick: () => JsCmd, ajax: Boolean = true) = A(id, content, onClick, ajax)
  def hyperlink(id: String, content: Renderable, url: String, target: Option[String] = None) = LinkAnchor(id, url, content, target)

  def div(id: Option[String], content: Renderable*) = Div(id.getOrElse(""), Composite(content:_*))
  def div(content: Renderable*): Div = div(None, content:_*)
  //TODO: make Seq
  def div(content: List[Renderable]): Div = div(None, content:_*)

  def li(content: Renderable*) = Li(Composite(content:_*))

  def span(id: Option[String], content: Renderable*) = Span(id.getOrElse(""), Composite(content:_*))
  def span(content: Renderable*): Span = span(None, Composite(content:_*))
  //TODO: make Seq
  def span(content: List[Renderable]): Span = span(None, Composite(content:_*))
  def span(id: Option[String], content: String): Span = span(id, R(content))

  def ul(content: Renderable*) = Ul(Composite(content:_*))

  def table(thead: Thead, tbody: Tbody) = Table(thead, tbody)
  def thead(content: Renderable*) = Thead(Composite(content:_*))
  def tbody(content: Renderable*) = Tbody(Composite(content:_*))
  def tr(id: Option[String], content: Renderable*) = Tr(id, Composite(content:_*))
  def th(content: Renderable) = Th(content)
  def th(content: String): Th = th(R(content))
  def td(content: Renderable) = Td(content)
  def td(content: String): Td = td(R(content))

  def pre(content: String) = Pre(R(content))
}
