package im.mange.jetboot

//TODO: should I be Styleable? maybe
//TODO: should I be Hideable ? almost definitely
//TODO: or should probably keep this trait to the minimum and mixin Hideable, Disableable etc - nah have a lower level trait for that
//TODO: possibly this could die now .. HtmlElement should not implement it ...
trait Widget extends Identifiable with Renderable