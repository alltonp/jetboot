package im.mange.jetpac

trait Hideable extends Identifiable {
  def hide = element.hide
  def show = element.show
}


