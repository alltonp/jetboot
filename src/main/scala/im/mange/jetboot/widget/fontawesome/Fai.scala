package im.mange.jetboot.widget.fontawesome

import im.mange.jetpac.{Styleable, R, Html, Renderable}

case class Fai(icon: String, size: Int, fixedWidth: Boolean, spin: Boolean, pulse: Boolean, inverse: Boolean) extends Renderable with Styleable {
  //TODO: de-dupe
  private val sizeString = size match {
    case 1 => Some("fa-lg")
    case x if x > 1 && x < 6 => Some(s"fa-${x}x")
    case _ => None
  }

  private val config = Seq(sizeString,
    if (fixedWidth) Some("fa-fw") else None,
    if (spin) Some("fa-spin") else None,
    if (pulse) Some("fa-pulse") else None,
    if (inverse) Some("fa-inverse") else None
  ).flatten.mkString(" ")

  private[fontawesome] def elem = Html.i().classes(classes).addClasses("fa", s"fa-$icon", s"$config").styles(styles)

  def render = elem.render
}

case class StackedFai(fai: Fai, large: Boolean) extends Renderable {
  def render = fai.elem.addClasses(if (large) "fa-stack-2x" else "fa-stack-1x").render
}

case class FaStack(icons: Seq[StackedFai], size: Int) extends Renderable {
  //TODO: de-dupe
  private val sizeString = size match {
    case 1 => Some("fa-lg")
    case x if x > 1 && x < 6 => Some(s"fa-${x}x")
    case _ => None
  }

  def render = Html.span(R(icons)).classes("fa-stack", sizeString.getOrElse("")).render
}
