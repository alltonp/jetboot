package im.mange.jetboot.widget.fontawesome

import im.mange.jetpac.Renderable

case class Fai(icon: String, size: Int, fixedWidth: Boolean, spin: Boolean, pulse: Boolean) extends Renderable {
  private val sizeString = size match {
    case 1 => Some("fa-lg")
    case x if x > 1 && x < 6 => Some(s"fa-${x}x")
    case _ => None
  }

  private val config = Seq(sizeString,
    if (fixedWidth) Some("fa-fw") else None,
    if (spin) Some("fa-spin") else None,
    if (pulse) Some("fa-pulse") else None
  ).flatten.mkString(" ")

  def render = <i class={s"fa fa-$icon $config"}></i>
}
