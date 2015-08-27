package im.mange.jetpac.page

import scala.reflect.ClassTag

abstract class CometPage[T: ClassTag] extends StaticPage {
  def cometActorName: String = implicitly[ClassTag[T]].runtimeClass.getSimpleName

  def render() = decorate( <lift:comet type={cometActorName}/> <div style="clear:both"></div> )
}