package im.mange.jetpac

import im.mange.jetpac.input._
import net.liftweb.http.js.JsCmd
import org.joda.time.LocalDate

object HtmlInput extends HtmlInputElements

trait HtmlInputElements {
  def checkBox(name: String, default: Boolean) = CheckBox(Field(name), default)

  def select(name: String, options: Seq[(String,String)], default: Option[String] = None) =
    Select(Field(name), options, "", default)

//  def select2(id: String, placeholder: String, options: Seq[(String,String)]) =
// Select2(id, toTuple("") +: options, placeholder, None)
//
//  def select2(id: String, options: Seq[(String,String)], default: String) =
// Select2(id, options, "", Some(default))

  def submitButton(id: String, buttonPresentation: ButtonPresentation, onSubmit: () => JsCmd) =
    SubmitButton(id, buttonPresentation, onSubmit)

  def button(id: String, buttonPresentation: ButtonPresentation, onSubmit: () => JsCmd) =
    Button(id, buttonPresentation, onSubmit)

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
