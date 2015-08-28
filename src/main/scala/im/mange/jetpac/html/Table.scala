package im.mange.jetpac.html

import im.mange.jetpac.event.EventHandling
import im.mange.jetpac.{Event, Styleable, Renderable}
import net.liftweb.http.js.JsCmd

//TODO: okay, theses are definitely all Elements

case class Th(content: Renderable) extends Renderable with Styleable {
  def render = <th class={classes.render} style={styles.render}>{content.render}</th>
}

case class Td(content: Renderable) extends Renderable with Styleable {
  def render = <td class={classes.render} style={styles.render}>{content.render}</td>
}

case class Tr(id: Option[String] ,content: Renderable) extends Renderable with Styleable with EventHandling {
  def baseElement = <tr id={id.getOrElse("")} class={classes.render} style={styles.render}>{content.render}</tr>

  def onClick(handler: String => JsCmd): this.type = addEvents(Event.onClick -> handler)
}

case class Tbody(content: Renderable) extends Renderable with Styleable {
  def render = <tbody class={classes.render} style={styles.render}>{content.render}</tbody>
}

case class Thead(content: Renderable) extends Renderable with Styleable {
  def render = <thead class={classes.render} style={styles.render}>{content.render}</thead>
}

case class Table(thead: Thead, tbody: Tbody) extends Renderable with Styleable {
  def render =
    <table class={classes.render} style={styles.render}>
      {thead.render}
      {tbody.render}
    </table>
}