package im.mange.jetpac

trait Fillable extends Identifiable {
  def fill(content: Renderable) = element.fill(content)
  def empty = element.empty
}
