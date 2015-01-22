package im.mange.jetboot.widget

import im.mange.jetboot.{Input, Hideable}
import net.liftweb.http.js.JsCmd

//TODO: should this be Styleable? - think no actually because of ButtonPresentation .. but that could be bogus
trait Button extends Input with Hideable {
  def presentation: ButtonPresentation
  def onClick: JsCmd
}
