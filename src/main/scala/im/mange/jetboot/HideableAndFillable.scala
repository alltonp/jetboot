package im.mange.jetboot

trait HideableAndFillable extends Hideable with Fillable {
  def emptyAndHide = element.emptyAndHide
  def fillAndShow(value: Renderable) = element.fillAndShow(value)
}
