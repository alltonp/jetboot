package im.mange.jetboot.bootstrap3

import im.mange.jetboot.bootstrap3.typography.Hx

object Typography {
  def h1(heading: String, secondary: Option[String] = None) = Hx(heading, secondary, 1)
  def h2(heading: String, secondary: Option[String] = None) = Hx(heading, secondary, 2)
  def h3(heading: String, secondary: Option[String] = None) = Hx(heading, secondary, 3)
  def h4(heading: String, secondary: Option[String] = None) = Hx(heading, secondary, 4)
  def h5(heading: String, secondary: Option[String] = None) = Hx(heading, secondary, 5)
  def h6(heading: String, secondary: Option[String] = None) = Hx(heading, secondary, 6)
}
