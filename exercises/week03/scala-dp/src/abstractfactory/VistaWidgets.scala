package abstractfactory

trait VistaWidgets {
  self: WindowFactory =>

  protected class VistaWindow(s: aScrollbar) extends Window(s)

  protected class VistaScrollbar extends Scrollbar

}