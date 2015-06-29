package im.mange.jetboot.input

import im.mange.jetboot.{Event, Js}
import im.mange.jetboot.widget.form.FormInput
import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmd
import org.joda.time.LocalDate
import net.liftweb.http.SHtml
import net.liftweb.http.js.JE.JsRaw
import net.liftweb.http.js.{JsCmd, JsExp}
import net.liftweb.util.Helpers._

//TIP: this depends on - https://github.com/RobinHerbots/jquery.inputmask (>= 3.1.62)
class MaskedBox(val field: Field, default: Option[String], readOnly: Boolean = false, mask: String) extends FormInput {
  var value = safeDefault

  private def safeDefault = default getOrElse "0"

  private def js = s"""$$(document).ready(function () {{
     |$$('#$id').inputmask();
     |}});""".stripMargin

  //TODO: make a method on the EventHandlers to do the handler bit
  override def render = <div>{attachHandlersToBase(baseElement)}
    <script type="text/javascript">{js}</script>
    </div>

  def baseElement = SHtml.text(value, onSubmit, "id" → id, "style" → styles.render, "class" → classes.render,
    "data-inputmask" → mask, if (readOnly) "disabled" → s"$readOnly" else "id" → id)

  private def onSubmit(value: String) { this.value = value }

  def onKeyUp (handler: String ⇒ JsCmd): this.type = addEvents(Event.onKeyUp -> handler)

  override def reset = Js.setElementValue(id, safeDefault) & (if (readOnly) Js.disableElement(id) else Js.enableElement(id))

  //TODO: need to override init with the JS inputmask init stuff
}

class NumericBox(field: Field,
                 alias: String = "numeric",
                 default: Option[String],
                 readOnly: Boolean = false,
                 autoGroup: Boolean = true,
                 groupSeparator: String = ",",
                 allowPlus: Boolean = false,
                 allowMinus: Boolean = false,
                 mask: String = "'suffix': ''")

  extends MaskedBox(field, default, readOnly, mask = s"""
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
  def apply(field: Field, default: Option[Long] = None) = new IntegerBox(field, default)
}

class IntegerBox(field: Field,
                 default: Option[Long],
                 readOnly: Boolean = false,
                 autoGroup: Boolean = true,
                 groupSeparator: String = ",",
                 min: Long = 0,
                 max: Long = Long.MaxValue,
                 allowPlus: Boolean = false,
                 allowMinus: Boolean = false)

  extends NumericBox(field, "integer", default.map(_.toString), readOnly, autoGroup, groupSeparator, allowPlus, allowMinus,
    mask = s"'min': $min,\n'max': $max")

object DecimalBox {
  def apply(field: Field, default: Option[BigDecimal] = None) = new DecimalBox(field, default)
}

class DecimalBox(field: Field,
                 default: Option[BigDecimal],
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

  extends NumericBox(field, "decimal", default.map(_.toString()), readOnly, autoGroup, groupSeparator, allowPlus, allowMinus,
    mask = s"""'digits': '$digits',
              |'digitsOptional': $digitsOptional,
              |'min': $min,
              |'max': $max,
              |$mask""".stripMargin)

object PercentageBox {
  def apply(field: Field, default: Option[BigDecimal] = None) = new PercentageBox(field, default)
}

class PercentageBox(field: Field,
                    default: Option[BigDecimal],
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
