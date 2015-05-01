package im.mange.jetboot.widget

import im.mange.jetboot.{Input, Hideable}
import net.liftweb.http.js.JsCmd

//TODO: should this be Styleable? - think no actually because of ButtonPresentation .. but that could be bogus
@deprecated("Use HtmlInput instead", "01/05/2015")
trait Button extends Input with Hideable {
  def presentation: ButtonPresentation
  def onClick: JsCmd
}
