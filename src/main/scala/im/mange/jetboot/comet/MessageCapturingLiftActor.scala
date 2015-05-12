package im.mange.jetboot.comet

import net.liftweb.actor.LiftActor
import net.liftweb.http.CometActor

trait BaseMessageCapturingActor extends HandleMultipleTimesMessageHandler {
  override def onMessage = capture :: super.onMessage

  def onCapturedMessage(message: Any, actor: LiftActor): Unit

  def capture: PartialFunction[Any, Unit] = {
    case x => onCapturedMessage(x, this)
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

trait HandleMultipleTimesMessageHandler extends LiftActor {
  def onMessage: List[PartialFunction[Any, Unit]] = Nil

  final def doOnMessage(message: Any) {
    onMessage.reverse.foreach(_(message))
  }
}

