package im.mange.jetboot.widget

import im.mange.jetboot.{R, Renderable}
import im.mange.jetboot.widget.table._

object SimpleTable {
  //TIP: http://spray.io/blog/2012-12-13-the-magnet-pattern/
  sealed trait RenderableMagnet { def apply(): Renderable }
  implicit def fromString(ss: String) = new RenderableMagnet { def apply() = R(ss) }
  implicit def fromR(r: Renderable) = new RenderableMagnet { def apply() = r }

  def simpleTable(headers: TableHeaders, rows: TableRow*) = Table(TableModel(headers, rows.toList))
  def simpleTable(headers: TableHeaders, rows: List[TableRow]) = Table(TableModel(headers, rows))
  def headers(tableHeaders: TableHeader*) = TableHeaders(tableHeaders.toList)
  def headers(tableHeaders: List[TableHeader]) = TableHeaders(tableHeaders)
  def header(r: Renderable) = TableHeader(r)
  def header(s: String) = TableHeader(R(s))
  def rows(rows: TableRow*) = rows.toList
  def rows(rows: List[TableRow]) = rows
  def trow(magnets: RenderableMagnet*): TableRow = TableRow(magnets.map(_.apply()))
  def trow(magnets: List[RenderableMagnet]): TableRow = TableRow(magnets.map(_.apply()))
}
