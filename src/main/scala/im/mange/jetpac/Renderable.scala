package im.mange.jetpac

import scala.xml.NodeSeq

trait Renderable {
  def render: NodeSeq
}
