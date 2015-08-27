package im.mange.jetboot.bootstrap.typography

import im.mange.jetpac.{Renderable, R, Html, Css}
import Css._
import Html._

case class Hx(heading: Renderable, secondary: Option[Renderable], x: Int) extends Renderable {
  def render = span(span(heading), secondary.fold(span())(s => span(R(" "), s)).classes(small)).classes(s"h$x").render
}
