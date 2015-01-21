package im.mange.jetboot

//TODO: should Id be an Option?
trait Identifiable {
  //TODO: could be a val maybe
  def id: String
  def element = Element(id)
}
