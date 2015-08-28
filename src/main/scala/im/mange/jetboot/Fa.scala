package im.mange.jetboot

import im.mange.jetboot.widget.fontawesome.Fai

object Fa {
  //TIP: see http://fortawesome.github.io/Font-Awesome/cheatsheet/

  def fa(icon: String, size: Int = 0, fixedWidth: Boolean = false, spin: Boolean = false, pulse: Boolean = false) =
    Fai(icon, size, fixedWidth, spin, pulse)
}
