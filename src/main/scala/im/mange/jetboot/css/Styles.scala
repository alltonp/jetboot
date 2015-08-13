package im.mange.jetboot.css



case class Styles(private val styles: Style*) {
  val render = styles.map(_.render).mkString(" ")
  def add(toAdd: Style*) = Styles(toAdd.toList ::: styles.toList)
}

object Styles {
  def apply(styles: List[Style]): Styles = Styles(styles:_*)
}

trait StyleKeys {
  def backgroundColor(value: String) = Style("background-color", value)
  def border(value: String*) = Style("border", value.mkString(" "))
  def color(value: String) = Style("color", value)
  def clear(value: String) = Style("clear", value)
  def display(value: String) = Style("display", value)
  def fontWeight(value: String) = Style("font-weight", value)
  def fontSize(value: String) = Style("font-size", value)
  def float(value: String) = Style("float", value)
  def height(value: String) = Style("height", value)
  def minHeight(value: String) = Style("min-height", value)
  def minWidth(value: String) = Style("min-width", value)
  def maxHeight(value: String) = Style("max-height", value)
  def maxWidth(value: String) = Style("max-width", value)
  def margin(value: String) = Style("margin", value)
  def marginTop(value: String) = Style("margin-top", value)
  def marginRight(value: String) = Style("margin-right", value)
  def marginBottom(value: String) = Style("margin-bottom", value)
  def marginLeft(value: String) = Style("margin-left", value)
  def overflow(value: String) = Style("overflow", value)
  def overflowX(value: String) = Style("overflow-x", value)
  def overflowY(value: String) = Style("overflow-y", value)
  def paddingTop(value: String) = Style("padding-top", value)
  def paddingRight(value: String) = Style("padding-right", value)
  def paddingBottom(value: String) = Style("padding-bottom", value)
  def paddingLeft(value: String) = Style("padding-left", value)
  def padding(top: String, right: String, bottom: String, left: String) = Style("padding", Seq(top, right, bottom, left).mkString(" "))
  def padding(top: String, rightAndLeft: String, bottom: String) = Style("padding", Seq(top, rightAndLeft, bottom).mkString(" "))
  def padding(topAndBottom: String, rightAndLeft: String) = Style("padding", Seq(topAndBottom, rightAndLeft).mkString(" "))
  def padding(value: String) = Style("padding", value)
  def position(value: String) = Style("position", value)
  def top(value: String) = Style("top", value)
  def textAlign(value: String) = Style("text-align", value)
  def textDecoration(value: String) = Style("text-decoration", value)
  def textOverflow(value: String) = Style("text-overflow", value)
  def width(value: String) = Style("width", value)
  def whiteSpace(value: String) = Style("white-space", value)
  def verticalAlign(value: String) = Style("vertical-align", value)
}

trait StyleValues {
  val absolute = "absolute"
  val auto = "auto"
  val bigger = "bigger"
  val block = "block"
  val bold = "bold"
  val both = "both"
  val center = "center"
  val ellipsis = "ellipsis"
  val hidden = "hidden"
  val inlineBlock = "inline-block"
  val large = "large"
  val larger = "larger"
  val left = "left"
  val medium = "medium"
  val middle = "middle"
  val none = "none"
  val nowrap = "nowrap"
  val right = "right"
  val scroll = "scroll"
  val small = "small"
  val smaller = "smaller"
  val solid = "solid"
  val underline = "underline"
  val xSmall = "x-small"
  val xLarge = "x-large"
  val xxSmall = "xx-small"
  val xxLarge = "xx-large"
  //  def ~#(value: Int) = s"#${value}"
//  def px(value: Int) = s"${value}px"
}
