package im.mange.jetboot.widget.inplace

import im.mange.jetpac.Js
import Js._

case class InPlaceHidden(id: String, value: String) extends InPlaceEditor {
  def render = <input type="hidden" id={id} value={value}/>
  def init = nothing
  def currentValue = element.getValue
}
