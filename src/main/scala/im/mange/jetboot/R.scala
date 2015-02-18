package im.mange.jetboot

import scala.xml.{NodeSeq, Text}

object R {
  def apply(renderables: Renderable*): Renderable = R(Composite(renderables:_*).render)
  def apply(renderables: List[Renderable]): Renderable = R(renderables:_*)
  def apply(content: String): Renderable = R(Text(content))
  def apply(): Renderable = R(NodeSeq.Empty)
}

case class R(private val content: NodeSeq) extends Renderable {
  def render = content
}
