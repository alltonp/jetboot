package im.mange.jetpac.comet

import im.mange.jetpac.Renderable
import net.liftweb.http.js.JsCmd

trait CometAgent extends Renderable {
  def on: PartialFunction[Any, JsCmd]
}
