package im.mange.jetboot.widget

import im.mange.jetboot.{R, Renderable}
import im.mange.jetboot.widget.table._

object SimpleTable {
  //TIP: http://spray.io/blog/2012-12-13-the-magnet-pattern/
  sealed trait RenderableMagnet { def apply(): Renderable }
  implicit def fromString(ss: String) = new RenderableMagnet { def apply() = R(ss) }
  implicit def fromR(r: Renderable) = new RenderableMagnet { def apply() = r }

//  def simpleTable(headers: TableHeaders, rows: TableRow*) = Table(TableModel(headers, rows.toList))
  def simpleTable(headers: TableHeaders, rows: Seq[TableRow]) = Table(TableModel(headers, rows))
//  def headers(tableHeaders: TableHeader*) = TableHeaders(tableHeaders.toList)
  def headers(tableHeaders: Seq[TableHeader]) = TableHeaders(tableHeaders)
  def header(r: Renderable) = TableHeader(r)
  def header(s: String) = TableHeader(R(s))
//  def rows(trows: TableRow*) = trows.toList
  def rows(trows: Seq[TableRow]) = trows
//  def trow(magnets: RenderableMagnet*): TableRow = trow(None, magnets:_*)
  def trow(magnets: Seq[RenderableMagnet]): TableRow = trow(None, magnets)
//  def trow(id: Option[String], magnets: RenderableMagnet*): TableRow = TableRow(id, magnets.map(_.apply()))
  def trow(id: Option[String], magnets: Seq[RenderableMagnet]): TableRow = TableRow(id, magnets.map(_.apply()))

}
