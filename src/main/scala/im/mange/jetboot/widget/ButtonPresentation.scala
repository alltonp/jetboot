package im.mange.jetboot.widget

import im.mange.jetpac.css.{Classes, Styles}

import scala.xml.NodeSeq

//TODO: possibly this should be a trait with implementations
//TODO: hmmm .. not sure this looks so good these days
@deprecated("Use new ButtonPresentation instead", "28/08/2015")
case class ButtonPresentation(body: NodeSeq, classes: Classes = Classes(), styles: Styles = Styles())
