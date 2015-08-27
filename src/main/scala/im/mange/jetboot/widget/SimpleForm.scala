package im.mange.jetboot.widget

trait SimpleForm {
  import im.mange.jetboot.widget.form._

  def simpleForm(id: String, inputs: Seq[FormInput]) = Form(id, inputs)
}