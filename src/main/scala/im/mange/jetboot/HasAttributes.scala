package im.mange.jetboot

trait HasAttributes {
  var attributes = Map.empty[String, String]

  def attribute(key: String, value: String): this.type = { attributes = attributes.updated(key, value); this }
}
