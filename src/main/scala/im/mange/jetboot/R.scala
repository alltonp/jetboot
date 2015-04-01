package im.mange.jetboot

import scala.xml.{NodeSeq, Text}

object R {
  sealed trait NodeSeqMagnet { def apply(): Renderable }
  implicit def fromString(ss: String) = new NodeSeqMagnet { def apply() = R(Text(ss)) }
  implicit def fromR(r: Renderable) = new NodeSeqMagnet { def apply() = r }
  implicit def fromNodeSeq(n: NodeSeq) = new NodeSeqMagnet { def apply() = R(n) }

//  def apply(renderables: Renderable*): Renderable = R(renderables.map(_.render):_*)
//  def apply(renderables: List[Renderable]): Renderable = R(renderables:_*)
//  def apply(content: NodeSeq*): Renderable = R(content.foldLeft(NodeSeq.Empty) {(result, r) ⇒ result ++ r })
//  def apply(content: String*): Renderable = R(content.map(Text(_)))
  def apply(): Renderable = R(NodeSeq.Empty)
  def apply(magnets: NodeSeqMagnet*): R = R(Composite(magnets.map(_.apply()):_*).render)
  def apply(magnets: List[NodeSeqMagnet]): R = R(Composite(magnets.map(_.apply()): _*).render)
}

case class R(private val content: NodeSeq) extends Renderable {
  def render = content
}
