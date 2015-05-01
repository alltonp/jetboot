package im.mange.jetboot.comet

import net.liftweb.http.CometActor
import net.liftweb.http.js.JsCmd

trait DebuggableCometActor extends CometActor {
  override protected def partialUpdate(cmd: => JsCmd): Unit = {
    println(s"### Begin partial update:\n[$cmd]\n### End partial update\n")
    super.partialUpdate(cmd)
  }
}
