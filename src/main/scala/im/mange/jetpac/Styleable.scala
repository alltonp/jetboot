package im.mange.jetpac

import im.mange.jetpac.css.{Classes, Style, Styles}

trait Styleable {
  var classes: Classes = Classes()
  var styles: Styles = Styles()

  def classes(c: Classes): this.type = {classes = c; this}
  def classes(c: String*): this.type = classes(Classes(c:_*))
  def styles(s: Styles): this.type = {styles = s; this}
  def styles(s: Style*): this.type = styles(Styles(s:_*))
  def addClasses(c: String*): this.type = { classes(classes.add(c:_*)) }
  def addStyles(s: Style*): this.type = { styles(styles.add(s:_*)) }
}


