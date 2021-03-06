package im.mange.jetboot.widget.table

import im.mange.jetpac.{Styleable, Renderable, Html}
import Html._
import im.mange.jetpac.css.{Classes, Style, Styles}

case class TableHeaders(headers: Seq[TableHeader]) {
  var theadClasses: Classes = Classes()
  var theadStyles: Styles = Styles()

  var trClasses: Classes = Classes()
  var trStyles: Styles = Styles()

  def theadClasses(c: Classes): this.type = {theadClasses = c; this}
  def theadClasses(c: String*): this.type = theadClasses(Classes(c:_*))
  def theadStyles(s: Styles): this.type = {theadStyles = s; this}
  def theadStyles(s: Style*): this.type = theadStyles(Styles(s:_*))

  def trClasses(c: Classes): this.type = {trClasses = c; this}
  def trClasses(c: String*): this.type = trClasses(Classes(c:_*))
  def trStyles(s: Styles): this.type = {trStyles = s; this}
  def trStyles(s: Style*): this.type = trStyles(Styles(s:_*))
}

case class TableHeader(content: Renderable) extends Renderable with Styleable {
  def render = th(content).classes(classes).styles(styles).render
}

case class TableRow(id: Option[String],cells: Seq[Renderable]) extends Styleable

case class TableModel(header: TableHeaders, rows: Seq[TableRow])

case class Table(tableModel: TableModel) extends Renderable with Styleable {
  def render = table(
    thead(
      tr(None,
        tableModel.header.headers:_*
      ).classes(tableModel.header.trClasses).styles(tableModel.header.trStyles)
    ).classes(tableModel.header.theadClasses).styles(tableModel.header.theadStyles),
    tbody(
      tableModel.rows.map(r ⇒ {
        tr(r.id,
          r.cells.map(td(_)):_*
        ).classes(r.classes).styles(r.styles)
      }):_*
    )//.classes(tableBodyStyle)
  ).classes(classes).styles(styles).render
}
