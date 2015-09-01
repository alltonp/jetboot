package im.mange.jetpac.input

import im.mange.jetpac.{Event, ButtonPresentation, Styleable, Input}
import net.liftweb.http.SHtml
import net.liftweb.http.SHtml._
import net.liftweb.http.js.JsCmd

//TODO: Styleable must die here ...
case class SubmitButton(id: String, buttonPresentation: ButtonPresentation, onSubmit: () => JsCmd) extends Input with Styleable {
  def render = ajaxOnSubmit(onSubmit)(<button id={id}
              style={buttonPresentation.styles.add(styles.styles:_*).render}
              class={buttonPresentation.classes.add(classes.classNames:_*).render}>{buttonPresentation.renderable.render}</button>)
}
