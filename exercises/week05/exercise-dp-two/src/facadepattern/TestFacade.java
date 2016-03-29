package facadepattern;

public class TestFacade {
    public static void main(String[] args) {
        ScheduleServer scheduleServer = new ScheduleServerImpl();
        ScheduleServerFacade facadeServer = new ScheduleServerFacade(scheduleServer);
        System.out.println("Start working......");
        facadeServer.startServer();
        System.out.println("After work done.........");
        facadeServer.stopServer();
    }
}