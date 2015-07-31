package im.mange.jetboot.comet

import im.mange.jetboot.Renderable
import net.liftweb.http.js.JsCmd

trait CometAgent extends Renderable {
  def on: PartialFunction[Any, JsCmd]
}
