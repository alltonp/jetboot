package im.mange.jetboot

import im.mange.jetboot.bootstrap3.{GridSystem, Typography}
import im.mange.jetboot.widget.{SimpleForm, SimpleTable}

//TODO: rename to Tables and Forms respectively ...
//TIP: we are kind of modeling this page: http://getbootstrap.com/css/#overview
object Bootstrap extends Typography with GridSystem with SimpleTable with SimpleForm {
}
