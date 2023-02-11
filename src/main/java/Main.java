import controller.StackOverflowController;
import service.Parser;

public class Main {

    public static void main(String[] args) {
        System.out.println("Wait for data processing.......");
        System.out.println("-------------------------------------------------");
        Parser parser = new Parser(new StackOverflowController());
        parser.parseUsersData();
    }
}
