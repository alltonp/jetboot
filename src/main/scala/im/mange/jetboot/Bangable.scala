package im.mange.jetboot

import net.liftweb.actor.LAFuture

trait Bangable[T] {
  def !(msg: T): scala.Unit
  def !<(msg: T): LAFuture[Any]
  def !?(msg: Any): Any
}
