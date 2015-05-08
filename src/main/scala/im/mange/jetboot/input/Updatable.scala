package im.mange.jetboot.input

import im.mange.jetboot.Identifiable
import im.mange.jetboot.Js._
import im.mange.jetboot.bootstrap3.Bootstrap.{alert, alertDanger}
import net.liftweb.http.js.JsCmd

//TODO: introduce Validatable
//TODO: is this really more like ValueUpdatable
//TODO: and ultimately it should live in im.mange.jetboot
//TODO: this has the wrong kind of bootstrap validation, it should be has-errors and not alert, but its a bit of work
trait Updatable { self: Identifiable =>

  def update(newValue: String): JsCmd =
    setElementValue(id, newValue) & removeElementClass(id, alert) & removeElementClass(id, alertDanger)

  def showError(message: String): JsCmd =
    setElementValue(id, message) & addElementClass(id, alert) & addElementClass(id, alertDanger)

  def showError2(message: String): JsCmd =
    addElementClass(id, "has-error")
}

//
//trait Updatable { self: Identifiable =>
//
//  def update(newValue: String): JsCmd =
//    setElementValue(id, newValue) & removeElementClass(id, "has-error")// & removeElementClass(id, alertDanger)
//
//  def showError(message: String): JsCmd =
//    setElementValue(id, message) & addElementClass(id, "has-error")// & addElementClass(id, alertDanger)
//}
