package im.mange.jetboot

trait Focusable extends Identifiable {
  def focus = element.focus
}
