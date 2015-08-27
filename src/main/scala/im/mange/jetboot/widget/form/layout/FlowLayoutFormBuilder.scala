package im.mange.jetboot.widget.form.layout

import im.mange.jetboot.widget.form.FormInput
import im.mange.jetboot.widget.form.FormLayout._
import im.mange.jetpac.{Renderable, R}

case class FlowLayoutFormBuilder(id: String, columns: Int = 12, prefixIdsWithParent: Boolean = false, layoutStrategy: LayoutStrategy = DefaultLayoutStrategy()) {
  private var formGroups: Seq[FormGroup] = Nil
  private var currentRow: Seq[LayoutElement] = Nil

  def finishGroup() = {
    formGroups = formGroups :+ formGroup(currentRow:_*)
    currentRow = Nil
    this
  }

  //TODO: should label ultimately be an R()
  def addInput(input: FormInput, label: Option[String]) = append(
    label.map(l => controlLabel(layoutStrategy.layout(R(l)), R(l))), formControl(layoutStrategy.layout(input), input)
  )

  //TODO: barf is size passed in is more than 'columns'
  def add(r: Renderable, padToEndOfRow: Boolean = false, size: Option[Int] = None) = {
    val sizeOfElement = size.getOrElse(layoutStrategy.layout(r))
    if (padToEndOfRow) {
      val remainingSpaceInRow = columns - currentRowSize
      if (remainingSpaceInRow == 0) { finishGroup(); append(None, RenderableElement(columns - sizeOfElement, R())) }
      if (remainingSpaceInRow > sizeOfElement) { append(None, RenderableElement(remainingSpaceInRow - sizeOfElement, R())) }
    }
    append(None, RenderableElement(sizeOfElement, r))
  }

  def build = {
    if (currentRow.nonEmpty) finishGroup()
    formLayout(id, prefixIdsWithParent, formGroups:_*)
  }

  private def append(label: Option[LayoutElement], input: LayoutElement) = {
    val countAfterAdding = currentRowSize + label.fold(0)(_.columns) + input.columns
    if (countAfterAdding > columns) finishGroup()
    label.foreach(l => currentRow = currentRow :+ l)
    currentRow = currentRow :+ input
    this
  }

  private def currentRowSize = currentRow.map(_.columns).sum
}
