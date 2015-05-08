package im.mange.jetboot

import im.mange.jetboot.input._
import net.liftweb.http.js.JsCmd
import org.joda.time.LocalDate

//TODO: ultimately merge liveXXX with XXX .. it's just an onChange event that's different
object HtmlInput {
  def checkBox(name: String, default: Boolean) = CheckBox(Field(name), default)

  //TODO: make default an Option
  def liveTextBox(name: String, placeholder: String) = LiveTextBox(Field(name), placeholder, "")

  //TODO: make default an Option
  def liveTextArea(name: String, placeholder: String) = LiveTextArea(Field(name), placeholder, "")

  //TODO: looks like there is some notion of a default here too .. i.e. empty or first
  def select(name: String, options: Seq[(String,String)]) =
    Select(Field(name), TupleMadness.toTuple("") +: options, "", None)

  //TODO: looks like there is some notion of a default here too .. i.e. empty or first
  def select(name: String, options: Seq[(String,String)], default: Option[String] = None) =
    Select(Field(name), options, "", default)

//  def select2(id: String, placeholder: String, options: Seq[(String,String)]) =
// Select2(id, toTuple("") +: options, placeholder, None)
//
//  def select2(id: String, options: Seq[(String,String)], default: String) =
// Select2(id, options, "", Some(default))

  def submitButton(id: String, value: String, onSubmit: () => JsCmd) = SubmitButton(id, value, onSubmit)

  def button(id: String, value: String, onSubmit: () => JsCmd) = Button(id, value, onSubmit)

  def textBox(name: String, placeholder: Option[String] = None, default: Option[String] = None) = 
    TextBox(Field(name), placeholder, default)

  def datePicker(name: String, default: Option[LocalDate] = None, weekends: Boolean = true) =
    DatePicker(Field(name), default, weekends)

  //TODO: make default an Option
  def integerBox(name: String) = IntegerBox(Field(name))

  //TODO: make default an Option
  def percentageBox(name: String, default: BigDecimal = BigDecimal(0)) = PercentageBox(Field(name), default)

  //TODO: make default an Option
  def decimalBox(name: String, default: BigDecimal = BigDecimal(0)) = DecimalBox(Field(name), default)
}

object TupleMadness {
  def toTuple[T](t: T): (T,T) = t -> t
}