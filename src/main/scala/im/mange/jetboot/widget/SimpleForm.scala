package im.mange.jetboot.widget

object SimpleForm {
  import im.mange.jetboot.widget.form._

  def simpleForm(id: String, inputs: Seq[FormInput]) = Form(id, inputs)
}