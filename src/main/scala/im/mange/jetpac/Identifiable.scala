package im.mange.jetpac

//TODO: should Id be an Option? most probably yes .. so then we have to deal with None's properly ...
trait Identifiable {
  def id: String
  def element = Element(id)
}
