package im.mange.jetboot

//TODO: start using this
//TODO: should this be Hideable? - nah that should be on Widget
//TODO: should this be Styleable? - think no actually because of ButtonPresentation .. but that could be bogus
//TOD: should we have an Updatable? - with element.setValue(value)
@deprecated("I need to die", "01/05/2015")
trait Input extends Widget with Disableable with Focusable
