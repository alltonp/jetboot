package im.mange.jetboot.comet

import net.liftweb.actor.LiftActor
import net.liftweb.http.CometActor
import net.liftweb.http.js.JsCmd

trait BaseMessageCapturingActor extends HandleMultipleTimesMessageHandler {
  override def onMessage = capture :: super.onMessage

  def onCapturedMessage(message: Any): Unit

  def capture: PartialFunction[Any, Unit] = {
    case x => onCapturedMessage(x)
  }
}

trait MessageCapturingLiftActor extends LiftActor with BaseMessageCapturingActor {
  override final protected def messageHandler = {
    case x => doOnMessage(x)
  }
}

trait MessageCapturingCometActor extends CometActor with BaseMessageCapturingActor {
  override final def lowPriority = {
    case x => doOnMessage(x)
  }
}

trait MessageCapturingCometAgent extends CometAgent with BaseMessageCapturingActor {
  override final def on: PartialFunction[Any, JsCmd] = {
    case x => doOnMessage(x); handleMessage(x)
  }

  def handleMessage: PartialFunction[Any, JsCmd]
}

trait HandleMultipleTimesMessageHandler {
  def onMessage: List[PartialFunction[Any, Unit]] = Nil

  final def doOnMessage(message: Any) {
    onMessage.reverse.foreach(_(message))
  }
}

