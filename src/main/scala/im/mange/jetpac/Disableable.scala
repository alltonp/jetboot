package im.mange.jetpac

trait Disableable extends Identifiable {
  def disable = element.disable
  def enable = element.enable
}
