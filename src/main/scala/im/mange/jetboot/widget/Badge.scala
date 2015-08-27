package im.mange.jetboot.widget

import im.mange.jetpac.{Renderable, R, Identifiable, Html}

case class Badge(id: String, value: String) extends Renderable with Identifiable {
  import Html._

  private val content = span(Some(id), R(value)).classes("badge", if (value.trim.isEmpty) "hidden" else "")

  override def render = content.render

  def update(value: String) = if (value.trim().isEmpty) content.emptyAndHide else content.fillAndShow(R(value))
}
