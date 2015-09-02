package im.mange.jetboot

import im.mange.jetboot.widget.fontawesome.{Fas, Fai}

object Fa extends FaElements

trait FaElements {
  //TIP: see http://fortawesome.github.io/Font-Awesome/cheatsheet/

  def fa(icon: String, size: Int = 0, fixedWidth: Boolean = false, spin: Boolean = false, pulse: Boolean = false, inverse: Boolean = false) =
    Fai(icon, size, fixedWidth, spin, pulse, inverse)

  def fas(icons: Seq[Fai], size: Int = 0) = Fas(icons, size)
}
