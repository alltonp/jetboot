package im.mange.jetboot

import scala.xml.{NodeSeq, Text}

object R {
  def apply(renderables: Renderable*): Renderable = R(renderables.map(_.render):_*)
  def apply(renderables: List[Renderable]): Renderable = R(renderables:_*)
  def apply(content: String*): Renderable = R(content.map(Text(_)))
  def apply(): Renderable = R(NodeSeq.Empty)
}

case class R(private val content: NodeSeq*) extends Renderable {
  def render = content.foldLeft(NodeSeq.Empty) {(result, r) ⇒ result ++ r }
}
