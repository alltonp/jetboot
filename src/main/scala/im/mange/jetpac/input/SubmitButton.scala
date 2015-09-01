package im.mange.jetpac.input

import im.mange.jetpac.{Event, ButtonPresentation, Styleable, Input}
import net.liftweb.http.SHtml
import net.liftweb.http.SHtml._
import net.liftweb.http.js.JsCmd

case class SubmitButton(id: String, buttonPresentation: ButtonPresentation, onSubmit: () => JsCmd) extends Input {
  def render = ajaxOnSubmit(onSubmit)(<button id={id}
              style={buttonPresentation.styles.render}
              class={buttonPresentation.classes.render}>{buttonPresentation.renderable.render}</button>)
}
