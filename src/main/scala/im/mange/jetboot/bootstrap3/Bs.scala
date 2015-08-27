package im.mange.jetboot.bootstrap3

//TODO: should this be called BootstrapStyles instead?
//TODO: ultamtely include the version so it's Bootstrap3Styles or something
//TODO: ideally drop the package too, jetboot = bootstrap after all
object Bs {
  val active = "active"

  val alert = "alert"
  val alertDanger = "alert-danger"

  val btn = "btn"
  val btnLg = "btn-lg"
  val btnSm = "btn-sm"
  val btnXs = "btn-xs"
  val btnBlock = "btn-block"
  val btnDefault = "btn-default"
  val btnPrimary = "btn-primary"
  val btnSuccess = "btn-success"
  val btnInfo = "btn-info"
  val btnWarning = "btn-warning"
  val btnDanger = "btn-danger"
  val btnLink = "btn-link"

  val container = "container"
  val containerFluid = "container-fluid"
  val controlLabel = "control-label"
  val colLg6 = "col-lg-6"
  val colLg12 = "col-lg-12"

  val fade = "fade"

  val formControl = "form-control"
  val formGroup = "form-group"
  val formGroupSm = "form-group-sm"
  val formGroupLg = "form-group-lg"
  val formInline = "form-inline"
  val formHorizontal = "form-horizontal"

  //TODO: should probably be pulled out
  val glyphicon = "glyphicon"
  def glyphicon(name: String) = "glyphicon glyphicon-" + name

  val hasError = "has-error "
  val helpBlock = "help-block"
  val hidden = "hidden"

  val in = "in"

  val inputSm = "input-sm"
  val inputLg = "input-lg"
  val inputGroupAddon = "input-group-addon"
  val inputGroup = "input-group"
  val inputGroupSm = "input-group-sm"
  val inputGroupLg = "input-group-lg"
  val inputGroupBtn = "input-group-btn"

  val jumbotron = "jumbotron"

  val label = "label"
  val labelDefault = "label-default"
  val labelPrimary = "label-primary"
  val labelSuccess = "label-success"
  val labelInfo = "label-info"
  val labelWarning = "label-warning"
  val labelDanger = "label-danger"

  val nav = "nav"
  val navbarNav = "navbar-nav"

  val panel = "panel"
  val panelBody = "panel-body"
  val panelDefault = "panel-default"
  val panelFooter = "panel-footer"
  val panelHeading = "panel-heading"

  val panelPrimary = "panel-primary"
  val panelSuccess = "panel-success"
  val panelInfo = "panel-info"
  val panelWarning = "panel-warning"
  val panelDanger = "panel-danger"

  val progress = "progress"
  val progressBar = "progress-bar"
  val progressBarSuccess = "progress-bar-success"
  val progressBarWarning = "progress-bar-warning"
  val progressBarDanger = "progress-bar-danger"
  val progressStriped = "progress-striped"

  val pullLeft = "pull-left"
  val pullRight = "pull-right"

  val row = "row"

  val table = "table"
  val tableBordered = "table-bordered"
  val tableCondensed = "table-condensed"
  val tableHover = "table-hover"
  val tableStriped = "table-striped"

  val tabContent = "tab-content"
  val tabPane = "tab-pane"

  val textCenter = "text-center"
  val textLeft = "text-left"
  val textRight = "text-right"
  val textJustify = "text-justify"
}
