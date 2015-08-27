package im.mange.jetboot.widget.form

import im.mange.jetboot._
import im.mange.jetpac._
import im.mange.jetpac.event.EventHandling
import im.mange.jetpac.input._
import net.liftweb.http.js.JsCmd

//TODO: this needs to be jetpac
trait FormInput extends Input with Styleable with EventHandling with Initialisable with Clearable with Updatable {
  val field: Field
  override def id = field.id
  def value: Any
  //TODO: this can probably die now, since we are moving towards all FormInputs init themselves correctly
  def init = Js.nothing
  def clear = Js.clearElementValue(id)
  def reset: JsCmd
}

//TODO: this is starting to look more like a field set kind of thing
case class Form(id: String, private val inputs: Seq[FormInput]) extends Initialisable with Disableable with Focusable with Hideable with Clearable with Resettable {
  def data = FormData(inputs.map(i => i.field.unContextualisedId -> i.value).toMap)

  override def clear = Js.chain(inputs.map(_.clear))
  override def reset = Js.chain(inputs.map(_.reset))
  //TODO: this can probably die for the same reason above
  override def init = Js.chain(inputs.map(_.init))
  override def focus = inputs.headOption.fold(Js.nothing)(_.focus)
  override def disable = Js.chain(inputs.map(_.disable))
  override def enable = Js.chain(inputs.map(_.enable))
}

//TODO: this should probably take the form id and contextualise
case class FormData(data: Map[String, Any]) {
  val fieldNames = data.keys.toSeq
  def valueOf(fieldName: String) = data(fieldName).toString.trim
}
