package im.mange.jetboot.widget.form

import im.mange.jetboot.widget.form.layout._
import im.mange.jetpac.{Renderable, R}

trait FormLayouts {
  def formLayout(id: String, prefixIdsWithParent: Boolean, groups: FormGroup*) = layout.FormLayout(id, groups.toSeq, prefixIdsWithParent)
  def formGroup(elements: LayoutElement*) = FormGroup(elements.toSeq)
  def controlLabel(columns: Int, label: Renderable) = ControlLabel(columns, label)
  def formControl(columns: Int, formInput: FormInput) = FormControl(columns, formInput)
  def renderable(columns: Int, renderable: Renderable) = RenderableElement(columns, renderable)
  def empty(columns: Int) = RenderableElement(columns, R())
}
