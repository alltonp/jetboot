package im.mange.jetboot

import im.mange.jetboot.widget.fontawesome.{StackedFai, FaStack, Fai}

object Fa extends FaElements

trait FaElements {
  //TIP: see http://fortawesome.github.io/Font-Awesome/cheatsheet/

  def fa(icon: String, size: Int = 0, fixedWidth: Boolean = false, spin: Boolean = false, pulse: Boolean = false, inverse: Boolean = false) =
    Fai(icon, size, fixedWidth, spin, pulse, inverse)

  def stack(fai: Fai, large: Boolean = false) = StackedFai(fai, large)

  def faStack(icons: Seq[StackedFai], size: Int = 0) = FaStack(icons, size)
}
