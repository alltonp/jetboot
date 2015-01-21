package im.mange.jetboot

import scala.xml.{NodeSeq, Text}

//TODO: do we need an S for Styleable?
//TODO: make an apply that takes (Renderable *) .. using a Composite underneath
object R {
  def apply(content: String): Renderable = R(Text(content))
  def apply(): Renderable = R(NodeSeq.Empty)
}

case class R(private val content: NodeSeq) extends Renderable {
  def render = content
}
