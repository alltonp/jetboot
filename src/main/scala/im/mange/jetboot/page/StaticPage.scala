package im.mange.jetboot.page

import scala.xml.NodeSeq

trait StaticPage extends Page {
  override def decorate(content: NodeSeq) = <div class="lift:surround?with=thing;at=content">{ content }</div>
}
