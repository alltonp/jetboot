package im.mange.jetpac

import im.mange.jetpac.input._
import net.liftweb.http.js.JsCmd
import org.joda.time.LocalDate

//TODO: ultimately merge liveXXX with XXX .. it's just an onChange event that's different
object HtmlInput extends HtmlInputElements

trait HtmlInputElements {
  def checkBox(name: String, default: Boolean) = CheckBox(Field(name), default)

  //TODO: make default an Option
  @deprecated("Use TextBox instead", "01/05/2015")
  def liveTextBox(name: String, placeholder: String) = LiveTextBox(Field(name), placeholder, "")

  //TODO: make default an Option
  @deprecated("Use TextArea instead", "01/05/2015")
  def liveTextArea(name: String, placeholder: String) = LiveTextArea(Field(name), placeholder, "")

  def select(name: String, options: Seq[(String,String)], default: Option[String] = None) =
    Select(Field(name), options, "", default)

//  def select2(id: String, placeholder: String, options: Seq[(String,String)]) =
// Select2(id, toTuple("") +: options, placeholder, None)
//
//  def select2(id: String, options: Seq[(String,String)], default: String) =
// Select2(id, options, "", Some(default))

  //TODO: make a version that takes a new style ButtonPresentation
  def submitButton(id: String, value: String, onSubmit: () => JsCmd) = SubmitButton(id, value, onSubmit)

//  ButtonPresentation(LabelledIcon("Rebook", Icons.squareO(0)), createButtonSm())
//  def submitButton(id: String, value: String, onSubmit: () => JsCmd) = SubmitButton(id, value, onSubmit)

  //TODO: make a version that takes a new style ButtonPresentation
  def button(id: String, value: String, onSubmit: () => JsCmd) = Button(id, value, onSubmit)

  def textBox(name: String, placeholder: Option[String] = None, default: Option[String] = None) = 
    TextBox(Field(name), placeholder, default)

  def textArea(name: String, placeholder: Option[String] = None, default: Option[String] = None) =
    TextArea(Field(name), placeholder, default)

  def datePicker(name: String, default: Option[LocalDate] = None, allowWeekends: Boolean = true) =
    DatePicker(Field(name), default, allowWeekends)

  def integerBox(name: String, default: Option[Long] = None) = IntegerBox(Field(name), default)

  def percentageBox(name: String, default: Option[BigDecimal]) = PercentageBox(Field(name), default)

  def decimalBox(name: String, default: Option[BigDecimal] = None) = DecimalBox(Field(name), default)
}
