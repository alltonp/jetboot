package im.mange.jetboot.widget

import im.mange.jetboot.Bss
import im.mange.jetpac.{Html, Identifiable, R, Renderable}
import im.mange.jetpac.css.Classes

case class Label(id: String, value: String, additionalClasses: Classes = Classes()) extends Renderable with Identifiable {
  import Html._
  import Bss._

  private val content = span(Some(id), R(value)).classes(additionalClasses).addClasses(label, if (value.trim.isEmpty) hidden else "")

  override def render = content.render

  def update(value: String) = if (value.trim().isEmpty) content.emptyAndHide else content.fillAndShow(R(value))
}
