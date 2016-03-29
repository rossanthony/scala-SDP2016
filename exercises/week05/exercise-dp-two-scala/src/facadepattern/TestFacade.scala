package facadepattern

object TestFacade {
  def main(args: Array[String]) {
    val scheduleServer: ScheduleServer = new ScheduleServerImpl
    val facadeServer: ScheduleServerFacade = new ScheduleServerFacade(scheduleServer)
    System.out.println("Start working......")
    facadeServer.startServer
    System.out.println("After work done.........")
    facadeServer.stopServer
  }
}