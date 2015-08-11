package im.mange.jetboot

import scala.xml.{NodeSeq, Text}

object R {
  //TIP: http://spray.io/blog/2012-12-13-the-magnet-pattern/
  sealed trait RenderableMagnet { def apply(): Renderable }
  implicit def fromString(s: String) = new RenderableMagnet { def apply() = R(Text(s)) }
  implicit def fromStrings(ss: Seq[String]) = new RenderableMagnet { def apply() = R(Text(ss.mkString)) }
  implicit def fromRenderable(r: Renderable) = new RenderableMagnet { def apply() = r }
  implicit def fromRenderables(r: Seq[Renderable]) = new RenderableMagnet { def apply() = Composite(r:_*) }
  implicit def fromNodeSeq(n: NodeSeq) = new RenderableMagnet { def apply() = R(n) }

  def apply(): Renderable = R(NodeSeq.Empty)
  def apply(magnets: RenderableMagnet*): R = doIt(magnets.map(_.apply()))
  private def doIt(magnets: Seq[Renderable]) = R(Composite(magnets: _*).render)

  case class Composite(renderables: Renderable*) extends Renderable {
    def render = renderables.foldLeft(NodeSeq.Empty) {(result, r) ⇒ result ++ r.render }
  }
}

case class R(private val content: NodeSeq) extends Renderable {
  def render = content
}
