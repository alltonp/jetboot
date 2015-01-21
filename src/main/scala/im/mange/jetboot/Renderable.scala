package im.mange.jetboot

import scala.xml.NodeSeq

trait Renderable {
  def render: NodeSeq
}
