package im.mange.jetboot.widget

@deprecated("Use HtmlInput instead", "01/05/2015")
trait LinkButton extends Button {
  import im.mange.jetboot.Js._

  //TODO: target should be configurable
  def url: String
  val onClick = nothing
  def render = <a href={url} id={id} target="_blank" class={presentation.classes.render} style={presentation.styles.render}>{presentation.body}</a>
}
