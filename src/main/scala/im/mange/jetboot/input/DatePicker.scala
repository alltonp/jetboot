package im.mange.jetboot.input

import im.mange.jetboot.Js
import im.mange.jetboot.widget.form.FormInput
import net.liftweb.http.SHtml
import org.joda.time.LocalDate

//TIP: this depends on https://eonasdan.github.io/bootstrap-datetimepicker/
case class DatePicker(field: Field, default: Option[LocalDate], allowWeekends: Boolean = true) extends FormInput {
  private val defaultStr = default.map(_.toString("dd/MM/yyyy")).getOrElse("")
  var value = defaultStr
  private def widgetId = s"datepicker-$id"
  private val daysOfWeekDisabled = if (allowWeekends) "" -> "" else "daysOfWeekDisabled" -> "[0,6]"
  private val options = Seq("format" -> "\"DD/MM/YYYY\"", "showTodayButton" -> "false", daysOfWeekDisabled).map(x => s"${x._1}:${x._2}")

  private def js = s"""$$(function () {
      |$$('#$widgetId').datetimepicker({${options.mkString(",")}});
      |});""".stripMargin

  //TIP: this font-size 7px is a nasty layout hack to support input-xs
  //TODO: remove the script and override init instead ....
  def baseElement = <div>
    <div class='input-group date' id={widgetId}>
      {SHtml.text(defaultStr, onSubmit, "id" → id, "style" → styles.render, "class" → classes.render)}
      <span class="input-group-addon" style="font-size: 7px;">
        <span class="glyphicon glyphicon-calendar"/>
      </span>
    </div>
    <script type="text/javascript">{js}</script>
  </div>

  private def onSubmit(value: String) { this.value = value }

  override def clear = super.clear & Js.setElementValue(id, defaultStr)

  //TODO: need to override init with the JS datetimepicker init stuff
}