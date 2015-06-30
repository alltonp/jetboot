package im.mange.jetboot.page

import net.liftweb.common.Full
import net.liftweb.sitemap.Menu.Menuable
import net.liftweb.sitemap.{ConvertableToMenu, Loc, Menu}
import net.liftweb.util.StringHelpers

import scala.xml.{Elem, NodeSeq}

trait Page {
  protected def params: Seq[Loc.LocParam[Any]] = Seq()
  def title: String = this.getClass.getSimpleName
  def path: String = StringHelpers.snakify(title)

  def render(): NodeSeq

  def menuItem(): ConvertableToMenu = params.foldLeft(menuRoot)((m, p) => m >> p)

  private def menuRoot: Menuable = Menu.i(title) / path

  protected def decorate(content: NodeSeq): Elem

  private lazy val pathAsList = path.split("/").toList

  protected[page] def view: PartialFunction[List[String], Left[() => Full[NodeSeq], Nothing]] = {
    case `pathAsList` ⇒ display()
  }

  protected def display() = Left(() ⇒ Full(render()))
}
