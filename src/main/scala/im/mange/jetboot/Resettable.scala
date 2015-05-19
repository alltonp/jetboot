package im.mange.jetboot

import net.liftweb.http.js.JsCmd

trait Resettable {
  def reset: JsCmd
}
