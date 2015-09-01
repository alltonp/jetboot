package im.mange.jetpac.input

import im.mange.jetpac.{Event, ButtonPresentation, Styleable, Input}
import net.liftweb.http.SHtml
import net.liftweb.http.SHtml._
import net.liftweb.http.js.JsCmd

//TODO: Styleable must die here ...
case class SubmitButton(id: String, buttonPresentation: ButtonPresentation, onSubmit: () => JsCmd) extends Input with Styleable {

//  def baseElement = SHtml.text(value, onSubmit, "id" → id, "style" → styles.render, "class" → classes.render,
//    "placeholder" → placeholder.getOrElse(""))

//  private def onSubmit(value: String) { this.value = value }

//  def onChange(handler: String => JsCmd): this.type = addEvents(Event.onChange -> handler)
//  def onKeyUp(handler: String => JsCmd): this.type = addEvents(Event.onKeyUp -> handler)


//  def render = ajaxSubmit(value, onSubmit, "id" -> id, "style" -> styles.render, "class" -> classes.render)
  def render = <input id={id} type="submit" style={buttonPresentation.styles.add(styles.styles:_*).render}
                      class={buttonPresentation.classes.add(classes.classNames:_*).render}>{ajaxOnSubmit(onSubmit)}</input>
}
