package im.mange.jetboot.widget.form

import im.mange.jetboot._
import im.mange.jetboot.event.EventHandling
import im.mange.jetboot.input._

trait FormInput extends Input with Styleable with EventHandling with Initialisable with Clearable with Updatable {
  val field: Field
  override def id = field.id
  def value: Any
  def init = Js.nothing
  def clear = Js.clearElementValue(id)
}

//TODO: this is starting to look more like a field set kind of thing
case class Form(id: String, private val inputs: Seq[FormInput]) extends Initialisable with Disableable with Focusable with Hideable with Clearable {
  def data = FormData(inputs.map(i => i.field.unContextualisedId -> i.value).toMap)

  override def clear = Js.chain(inputs.map(_.clear))
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
