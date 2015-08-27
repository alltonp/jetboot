package im.mange.jetpac

trait HasAttributes {
  var attributes = Map.empty[String, String]

  //TODO: should probably support maps ...
  def addAttribute(key: String, value: String): this.type = { attributes = attributes.updated(key, value); this }
}
