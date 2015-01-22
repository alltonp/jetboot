package im.mange.jetboot.widget

import im.mange.jetboot._
import net.liftweb.http.SHtml._

case class Collapsible(id: String, label: String, theContent: Renderable, expandedByDefault: Boolean = false) extends Renderable {
  import Html._
  import Css._

  private var expanded = expandedByDefault
  private val link = Element("collapsibleLink_" + id)
  private val collapsibleContent = div(id="collapsibleContent_" + id, theContent).classes(if (expandedByDefault) "" else Css.hidden)
  private val contentHolder = div(id="collapsibleSection_" + id, content).styles(marginBottom("10px"))

  def render = contentHolder.render

  private def content =
    Composite(
      R(<span>{displayExpander().render}</span>),
      collapsibleContent
    )

  private def displayExpander() = {
    R(a(() => toggle(),
      <button class={"btn btn-block btn-success" + (if (expanded) " active" else "")} data-toggle="button" style="font-weight:bold" id={link.id}>{icon().render}</button>,
      "style" -> "text-decoration: none;"
    ))
  }

  private def toggle() = {
    if (expanded) {
      expanded = false
      collapse()
    } else {
      expanded = true
      expand()
    }
  }

  private def expand() = collapsibleContent.show & link.fill(closeIcon())
  private def collapse() = collapsibleContent.hide & link.fill(openIcon())
  private def openIcon() = R(<span>{/*Glyphicons.chevronRight()*/}&nbsp;{label}&nbsp;</span>)
  private def closeIcon() = R(<span>{/*Glyphicons.chevronDown()*/}&nbsp;{label}&nbsp;</span>)
  private def icon() = if (expanded) closeIcon() else openIcon()
}
