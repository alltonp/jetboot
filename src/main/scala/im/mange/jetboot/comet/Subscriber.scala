package im.mange.jetboot.comet

trait Subscriber {
  def !(msg: Any)
}