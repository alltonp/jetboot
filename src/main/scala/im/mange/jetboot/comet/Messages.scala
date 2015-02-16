package im.mange.jetboot.comet

case class Subscribe(subscriber: Subscriber)
case class Unsubscribe(subscriber: Subscriber)
case class PushToAllSubscribers(message: Any)
