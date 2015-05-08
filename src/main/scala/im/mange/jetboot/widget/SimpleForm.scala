package im.mange.jetboot.widget

object SimpleForm {
  import im.mange.jetboot.widget.form._

  def form(id: String, inputs: Seq[FormInput]) = Form(id, inputs)
}