package im.mange.jetboot.bootstrap

import im.mange.jetboot.Bss
import Bss._
import im.mange.jetpac.{Styleable, Renderable, R}

//TIP: for full-width use: "padding: 0 15px"
trait GridSystem {
  //TODO: fix annoying name clashes with Bootstrap._
  def container(rows: Row*) = Container(rows)
  def containerFluid(rows: Row*) = Container(rows, fluid = true)
  def row(spans: Column*) = Row(spans)
  def col(columns: Int, content: Renderable, offset: Int) = Column(columns, content, offset)
  def col(columns: Int, content: Renderable*): Column = col(columns, R(content), 0)
//  def col(columns: Int, content: Seq[Renderable]): Column = col(columns, R(content), 0)
}

case class Container(rows: Seq[Row], fluid: Boolean = false) extends Renderable {
  def render = <div class={if (fluid) containerFluid else container}>{rows.map(_.render)}</div>
}

//TODO: internally - should I be a div()?
case class Row(columns: Seq[Column]) extends Renderable with Styleable {
  def render = <div class={classes.add(row).render} style={styles.render}>{columns.map(_.render)}</div>
}

//TODO: internally - should I be a div?
case class Column(columns: Int, content: Renderable, offset: Int = 0) extends Renderable with Styleable {
  private val spanClasses = "col-md-" + columns + (if (offset > 0) " offset" + offset else "")
  def render = <div class={classes.add(spanClasses).render} style={styles.render}>{content.render}</div>
}