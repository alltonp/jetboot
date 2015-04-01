package im.mange.jetboot

import scala.xml.{NodeSeq, Text}

object R {
  sealed trait RenderableMagnet { def apply(): Renderable }
  implicit def fromString(ss: String) = new RenderableMagnet { def apply() = R(Text(ss)) }
  implicit def fromR(r: Renderable) = new RenderableMagnet { def apply() = r }
  implicit def fromNodeSeq(n: NodeSeq) = new RenderableMagnet { def apply() = R(n) }

  def apply(): Renderable = R(NodeSeq.Empty)
  def apply(magnets: RenderableMagnet*): R = R(Composite(magnets.map(_.apply()):_*).render)
  def apply(magnets: List[RenderableMagnet]): R = R(Composite(magnets.map(_.apply()): _*).render)
}

case class R(private val content: NodeSeq) extends Renderable {
  def render = content
}
