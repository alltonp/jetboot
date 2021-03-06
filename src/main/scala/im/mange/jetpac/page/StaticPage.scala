package im.mange.jetpac.page

import scala.xml.NodeSeq

trait StaticPage extends Page {
  override def decorate(content: NodeSeq) = <div class="lift:surround?with=app;at=content">{ content }</div>
}
