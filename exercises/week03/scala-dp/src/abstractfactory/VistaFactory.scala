package abstractfactory

object VistaFactory extends WindowFactory {
  type aWindow = VistaWindow
  type aScrollbar = VistaScrollbar
  val window: aWindow = new VistaWindow(scrollbar)
  val scrollbar: aScrollbar = new VistaScrollbar

  def createWindow(s: aScrollbar) = new VistaWindow(s)

  def createScrollbar() = new VistaScrollbar

  protected class VistaWindow(s: aScrollbar) extends Window(s)

  protected class VistaScrollbar extends Scrollbar

}
