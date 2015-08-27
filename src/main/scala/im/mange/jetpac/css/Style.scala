package im.mange.jetpac.css

case class Style(key: String, value: String) {
  val render = s"${key}: ${value};"
}
