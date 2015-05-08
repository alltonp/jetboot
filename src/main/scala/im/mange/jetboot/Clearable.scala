package im.mange.jetboot

import net.liftweb.http.js.JsCmd

trait Clearable {
  def clear: JsCmd
}
