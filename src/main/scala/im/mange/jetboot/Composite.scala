package im.mange.jetboot

import scala.xml.NodeSeq

//TODO: allow creation from a Seq too .. otherwise we end up doing a lot of :_*
@deprecated("Use R() instead", "08/05/2015")
case class Composite(renderables: Renderable*) extends Renderable {
  def render = renderables.foldLeft(NodeSeq.Empty) {(result, r) ⇒ result ++ r.render }
}
