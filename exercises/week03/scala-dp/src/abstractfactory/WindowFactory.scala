package abstractfactory

trait WindowFactory {
  type aWindow <: Window
  type aScrollbar <: Scrollbar

  def createWindow(s: aScrollbar)

  def createScrollbar()

  abstract class Window(s: aScrollbar)

  abstract class Scrollbar

}
