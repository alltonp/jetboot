package im.mange.jetpac

import net.liftweb.http.js.JsCmd

trait Clearable {
  def clear: JsCmd
}
