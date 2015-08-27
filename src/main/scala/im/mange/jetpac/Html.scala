package im.mange.jetpac

import im.mange.jetpac.html._
import net.liftweb.http.js.JsCmd

object Html {
  def a(id: String, content: Renderable, onClick: () => JsCmd, ajax: Boolean = true) = A(id, content, onClick, ajax)
  def hyperlink(id: String, content: Renderable, url: String, target: Option[String] = None) = LinkAnchor(id, url, content, target)

  def div(id: Option[String], content: Renderable*) = Div(id.getOrElse(""), R(content))
  def div(content: Renderable*): Div = div(None, content:_*)
//  def div(content: Seq[Renderable]): Div = div(None, content:_*)

  def li(content: Renderable*) = Li(R(content))

  def span(id: Option[String], content: Renderable*) = Span(id.getOrElse(""), R(content))
  def span(content: Renderable*): Span = span(None, R(content))
//  def span(content: Seq[Renderable]): Span = span(None, R(content))
  def span(id: Option[String], content: String): Span = span(id, R(content))

  def ul(content: Renderable*) = Ul(R(content))

  def table(thead: Thead, tbody: Tbody) = Table(thead, tbody)
  def thead(content: Renderable*) = Thead(R(content))
  def tbody(content: Renderable*) = Tbody(R(content))
  def tr(id: Option[String], content: Renderable*) = Tr(id, R(content))
  def tr(content: Renderable*) = Tr(None, R(content))
  def th(content: Renderable) = Th(content)
  def th(content: String): Th = th(R(content))
  def td(content: Renderable) = Td(content)
  def td(content: String): Td = td(R(content))

  def pre(content: String) = Pre(R(content))
}
