package im.mange.jetboot

trait Hideable extends Identifiable {
  def hide = element.hide
  def show = element.show
}
