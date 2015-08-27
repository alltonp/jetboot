package im.mange.jetboot.widget

import im.mange.jetpac.Renderable

case class Spacer() extends Renderable {
  def render = <b>&nbsp;</b>
}
