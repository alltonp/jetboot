package im.mange.jetboot.widget.form

import im.mange.jetboot.Bss
import im.mange.jetpac.{Js, Identifiable}
import Js._
import Bss._
import im.mange.jetpac.Identifiable
import net.liftweb.http.js.JsCmd

//TODO: this thing really really needs some work ... (/killing)
//TODO: introduce Validatable
//TODO: is this really more like ValueUpdatable
//TODO: this has the wrong kind of bootstrap validation, it should be has-errors and not alert, but its a bit of work
trait Updatable { self: Identifiable =>

  def update(newValue: String): JsCmd =
    setElementValue(id, newValue) & removeElementClass(id, alert) & removeElementClass(id, alertDanger)

  def showError(message: String): JsCmd =
    setElementValue(id, message) & addElementClass(id, alert) & addElementClass(id, alertDanger)

  def showError2(message: String): JsCmd =
    addElementClass(id, hasError)
}
