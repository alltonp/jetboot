package im.mange.jetboot

trait Fillable extends Identifiable {
  def fill(content: Renderable) = element.fill(content)
  def empty = element.empty
}
