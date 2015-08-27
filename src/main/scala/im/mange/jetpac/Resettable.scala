package im.mange.jetpac

import net.liftweb.http.js.JsCmd

trait Resettable {
  def reset: JsCmd
}
