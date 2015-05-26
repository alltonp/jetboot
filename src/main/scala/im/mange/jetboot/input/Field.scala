package im.mange.jetboot.input

import im.mange.little.string.Strings

case class Field(name: String, var parent: Option[String] = None) {
  private val safeId = name.replaceAll("\\.", "").replaceAll(" ", "")
  //TODO: makeSafe, i.e. remove other funny id breaking chars etc
  //see http://stackoverflow.com/questions/70579/what-are-valid-values-for-the-id-attribute-in-html
  //.replaceAll(" ", "").replaceAll(".", "").replaceAll(":", "")

  private def contextualisedId(safeId: String) = s"${parent.fold("")(_ + "_")}${safeId}"

  def id = contextualisedId(safeId)
  def unContextualisedId = safeId
  val label = Strings.titleCase(name)
  //TODO: placeholder - option
}
