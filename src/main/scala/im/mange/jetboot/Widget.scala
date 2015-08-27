package im.mange.jetboot

import im.mange.jetboot.widget.form.FormInput
import im.mange.jetboot.widget.table.{TableHeaders, TableRow}
import im.mange.jetboot.widget.{SimpleForm, SimpleTable}

//TODO: decide whether to drop the 'simple' or not ... +ve prevents name clash
//TODO: hang all other widgets off here
object Widget {
  def simpleTable(headers: TableHeaders, rows: Seq[TableRow]) = SimpleTable.simpleTable(headers, rows)
  def simpleForm(id: String, inputs: Seq[FormInput]) = SimpleForm.simpleForm(id, inputs)
}
