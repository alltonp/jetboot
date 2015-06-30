package im.mange.jetboot.widget.form.layout

import im.mange.jetboot.Renderable
import im.mange.jetboot.widget.form.FormInput

trait LayoutStrategy {
  def layout(label: Renderable): Int
  def layout(e: FormInput): Int
}

case class DefaultLayoutStrategy() extends LayoutStrategy {
  def layout(label: Renderable) = label match { case x => 1 }
  def layout(e: FormInput) = e match { case x => 2 }
}