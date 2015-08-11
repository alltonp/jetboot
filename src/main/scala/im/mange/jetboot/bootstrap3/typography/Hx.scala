package im.mange.jetboot.bootstrap3.typography

import im.mange.jetboot.Css._
import im.mange.jetboot.Html._
import im.mange.jetboot.{R, Renderable}

case class Hx(heading: String, secondary: Option[String], x: Int) extends Renderable {
  def render = span(span(R(heading)), secondary.fold(span())(s => span(R(s" ${s}"))).classes(small)).classes(s"h$x").render
}
