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

//TIP: this depends on https://eonasdan.github.io/bootstrap-datetimepicker/
case class DatePicker(field: Field, default: Option[LocalDate], allowWeekends: Boolean = true) extends FormInput {
  private val defaultStr = default.map(_.toString("dd/MM/yyyy")).getOrElse("")
  var value = defaultStr
  private def widgetId = s"datepicker-$id"
  private val daysOfWeekDisabled = if (allowWeekends) "" -> "" else "daysOfWeekDisabled" -> "[0,6]"
  private val options = Seq("format" -> "\"DD/MM/YYYY\"", "showTodayButton" -> "false", daysOfWeekDisabled).map(x => s"${x._1}:${x._2}")

  //TIP: we have to simulate onchange - https://github.com/Eonasdan/bootstrap-datetimepicker/issues/983
  private def js = s"""$$(function () {
      |$$('#$widgetId').datetimepicker({${options.mkString(",")}})
      |.on('dp.hide',function (e) {
      |$$('#$id').trigger('change');
      |});
      |});""".stripMargin

  //TIP: this font-size 7px is a nasty layout hack to support input-xs
  //TODO: this is all a bit nasty, it's because EventHandlers is broken
  override def render = <div>
    <div class='input-group date' id={widgetId}>
      {attachHandlersToBase(baseElement)}
      <span class="input-group-addon" style="font-size: 7px;">
        <span class="glyphicon glyphicon-calendar"/>
      </span>
    </div>
    <script type="text/javascript">{js}</script>
  </div>

  def baseElement = {
    SHtml.text(defaultStr, onSubmit, "id" → id, "style" → styles.render, "class" → classes.render)
  }

  private def onSubmit(value: String) { this.value = value }

  def onChange(handler: (String) => JsCmd) = addEvents(Event.onChange -> handler)
  def onKeyUp(handler: (String) => JsCmd) = addEvents(Event.onKeyUp -> handler)

  override def reset = Js.setElementValue(id, defaultStr)
}