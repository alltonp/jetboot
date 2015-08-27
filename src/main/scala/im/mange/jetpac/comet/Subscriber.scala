package im.mange.jetpac.comet

trait Subscriber {
  def !(msg: Any)
}