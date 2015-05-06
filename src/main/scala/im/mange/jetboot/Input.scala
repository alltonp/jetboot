package im.mange.jetboot

//TODO: start using this
//TODO: should this be Hideable? - nah that should be on Widget
//TODO: should this be Styleable? - think no actually because of ButtonPresentation .. but that could be bogus
//TOD: should we have an Updatable? - with element.setValue(value)
trait Input extends Identifiable with Renderable with Disableable with Focusable
