package im.mange.jetpac

trait Focusable extends Identifiable {
  def focus = element.focus
}
