package im.mange.jetboot.widget

import im.mange.jetboot.widget.form.FormLayouts
import im.mange.jetboot.widget.form.layout.{FormGroup, FormLayout}
import im.mange.jetpac.Renderable

trait Forms extends FormLayouts {
  import im.mange.jetboot.widget.form._

  def simpleForm(id: String, inputs: Seq[FormInput]) = Form(id, inputs)
  def formHolder(columns: Int, formLayout: FormLayout, beforeLayout: Option[Renderable] = None,
                 afterLayout: Option[Renderable] = None) = FormHolder(columns, formLayout, beforeLayout, afterLayout)
}