package im.mange.jetpac

import im.mange.jetpac.css.{Classes, Styles}

//TODO: would it make more sense if this was Styleable?
case class ButtonPresentation(renderable: Renderable, classes: Classes = Classes(), styles: Styles = Styles())
