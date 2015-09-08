package im.mange.jetboot.widget

import im.mange.jetpac._

case class Badge(id: String, value: String) extends Renderable with Identifiable with Styleable {
  import Html._

  private val content = span(Some(id), R(value))
    .styles(styles)
    .classes(classes.add("badge", if (value.trim.isEmpty) "hidden" else ""))

  override def render = content.render

  def update(value: String) = if (value.trim().isEmpty) content.emptyAndHide else content.fillAndShow(R(value))
}
