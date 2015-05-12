package im.mange.jetboot.comet

import net.liftweb.actor.LiftActor

import scala.collection.immutable.HashSet

trait MulticastLiftActor extends LiftActor with HandleMultipleTimesMessageHandler {
  //TODO: ultimately might want to add a 'context' to the Subscribe message and store what clients are interested in
  private var subcribers = HashSet[Subscriber]()

  override def onMessage = (subscriptions orElse handleMessage) :: super.onMessage

  def subscriptions: PartialFunction[Any, Unit] = {
    case Subscribe(s) => subcribers = subcribers + s; afterSubscribe(s)
    case Unsubscribe(s) => subcribers = subcribers - s; afterUnsubscribe(s)
    case PushToAllSubscribers(m) => subcribers.par.foreach(_ ! m)
  }

  def handleMessage: PartialFunction[Any, Unit]
  def afterSubscribe(s: Subscriber) { }
  def afterUnsubscribe(s: Subscriber) { }
}

