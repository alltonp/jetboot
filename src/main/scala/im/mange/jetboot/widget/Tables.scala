package im.mange.jetboot.widget

import im.mange.jetboot.widget.table._
import im.mange.jetpac.{Renderable, R}

trait Tables {
  //TIP: http://spray.io/blog/2012-12-13-the-magnet-pattern/
  sealed trait RenderableMagnet { def apply(): Renderable }
  implicit def fromString(ss: String) = new RenderableMagnet { def apply() = R(ss) }
  implicit def fromR(r: Renderable) = new RenderableMagnet { def apply() = r }

  def bsTable(headers: TableHeaders, rows: Seq[TableRow]) = Table(TableModel(headers, rows))
  def headers(tableHeaders: Seq[TableHeader]) = TableHeaders(tableHeaders)
  def header(r: Renderable) = TableHeader(r)
  def header(s: String) = TableHeader(R(s))
  def rows(trows: Seq[TableRow]) = trows
  def trow(magnets: Seq[RenderableMagnet]): TableRow = trow(None, magnets)
  def trow(id: Option[String], magnets: Seq[RenderableMagnet]): TableRow = TableRow(id, magnets.map(_.apply()))
}
