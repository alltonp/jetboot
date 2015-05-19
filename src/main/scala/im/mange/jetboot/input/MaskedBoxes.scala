package im.mange.jetboot.input

import im.mange.jetboot.widget.form.FormInput
import im.mange.jetboot.{Event, Js}
import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmd

//TIP: this depends on - https://github.com/RobinHerbots/jquery.inputmask (>= 3.1.62)
class MaskedBox(val field: Field, default: String, readOnly: Boolean = false, mask: String) extends FormInput {
  var value = default

  def baseElement = SHtml.text(default, onSubmit, "id" → id, "style" → styles.render, "class" → classes.render,
    "data-inputmask" → mask, if (readOnly) "disabled" → s"$readOnly" else "id" → id
  )

  private def onSubmit(value: String) { this.value = value }

  def onKeyUp (handler: String ⇒ JsCmd): this.type = addEvents(Event.onKeyUp -> handler)

  override def reset = Js.setElementValue(id, default)

  //TODO: need to override init with the JS inputmask init stuff
}

class NumericBox(field: Field,
                 alias: String = "numeric",
                 default: String = "0",
                 readOnly: Boolean = false,
                 autoGroup: Boolean = true,
                 groupSeparator: String = ",",
                 allowPlus: Boolean = false,
                 allowMinus: Boolean = false,
                 mask: String = "'suffix': ''")

  extends MaskedBox(field, default.toString, readOnly, mask = s"""
                                                              |'alias': '$alias',
                                                              |'autoGroup': $autoGroup,
                                                              |'groupSeparator': ',',
                                                              |'placeholder': '0',
                                                              |'allowPlus': $allowPlus,
                                                              |'allowMinus': $allowMinus,
                                                              |'autoUnmask': true,
                                                              |'clearMaskOnLostFocus': false,
                                                              |'selectOnClick': true,
                                                              |$mask""".stripMargin)

object IntegerBox {
  def apply(field: Field) = new IntegerBox(field)
}

class IntegerBox(field: Field,
                 default: Long = 0,
                 readOnly: Boolean = false,
                 autoGroup: Boolean = true,
                 groupSeparator: String = ",",
                 min: Long = 0,
                 max: Long = Long.MaxValue,
                 allowPlus: Boolean = false,
                 allowMinus: Boolean = false)

  extends NumericBox(field, "integer", default.toString, readOnly, autoGroup, groupSeparator, allowPlus, allowMinus,
    mask = s"'min': $min,\n'max': $max")

object DecimalBox {
  def apply(field: Field, default: BigDecimal = BigDecimal(0)) = new DecimalBox(field, default)
}

class DecimalBox(field: Field,
                 default: BigDecimal = BigDecimal(0),
                 readOnly: Boolean = false,
                 autoGroup: Boolean = true,
                 groupSeparator: String = ",",
                 min: BigDecimal = BigDecimal(0),
                 max: BigDecimal = BigDecimal(Double.MaxValue),
                 digits: String = "*",
                 digitsOptional: Boolean = true,
                 allowPlus: Boolean = false,
                 allowMinus: Boolean = false,
                 mask: String = "'suffix': ''")

  extends NumericBox(field, "decimal", default.toString(), readOnly, autoGroup, groupSeparator, allowPlus, allowMinus,
    mask = s"""'digits': '$digits',
              |'digitsOptional': $digitsOptional,
              |'min': $min,
              |'max': $max,
              |$mask""".stripMargin)

object PercentageBox {
  def apply(field: Field, default: BigDecimal = BigDecimal(0)) = new PercentageBox(field, default)
}

class PercentageBox(field: Field,
                    default: BigDecimal = BigDecimal(0),
                    readOnly: Boolean = false,
                    autoGroup: Boolean = true,
                    groupSeparator: String = ",",
                    min: BigDecimal = BigDecimal(0),
                    max: BigDecimal = BigDecimal(Double.MaxValue),
                    digits: Int = 2,
                    digitsOptional: Boolean = false,
                    allowPlus: Boolean = false,
                    allowMinus: Boolean = false)

  extends DecimalBox(field, default, readOnly, autoGroup, groupSeparator, min, max, digits.toString, digitsOptional,
    allowPlus, allowMinus, mask = "'suffix': ' %'")
