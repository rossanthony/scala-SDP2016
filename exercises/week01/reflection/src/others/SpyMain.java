package others;


public class SpyMain {
    public static void main(String args[]) {
        try {
            Spy thisClassPrinter = Spy.getSpy("Spy");
            thisClassPrinter.printAll(args);
        } catch (ClassNotFoundException ex) {
            System.err.println("It broke!");
        }
    }
}
