package im.mange.jetboot.widget.form.layout

import im.mange.jetboot.widget.form.FormInput
import im.mange.jetboot.Bootstrap._
import im.mange.jetpac.Renderable

case class FixedLayoutFormBuilder(id: String, prefixIdsWithParent: Boolean = false) {
  private var formGroups: Seq[FormGroup] = Nil
  private var currentRow: Seq[LayoutElement] = Nil

  def finishGroup() = {
    formGroups = formGroups :+ formGroup(currentRow:_*)
    currentRow = Nil
    this
  }

  def addLabel(columns: Int, label: Renderable) = doAdd(controlLabel(columns, label))
  def addInput(columns: Int, input: FormInput) = doAdd(formControl(columns, input))
  def add(columns: Int, r: Renderable) = doAdd(renderable(columns, r))

  private def doAdd(e: LayoutElement) = {
    currentRow = currentRow :+ e
    this
  }

  def build = {
    if (currentRow.nonEmpty) finishGroup()
    formLayout(id, prefixIdsWithParent, formGroups:_*)
  }
}
