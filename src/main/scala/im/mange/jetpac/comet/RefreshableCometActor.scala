package im.mange.jetpac.comet

import net.liftweb.http.{CometActor, RenderOut}

trait RefreshableCometActor extends CometActor {
  def render = {
    beforeRefresh()
    doRefresh()
    afterRefresh()
    doRender
  }

  def beforeRefresh(): Unit
  def doRefresh(): Unit
  def afterRefresh(): Unit
  def doRender: RenderOut
}
