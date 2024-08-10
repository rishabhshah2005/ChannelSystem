import java.sql.SQLException;
import java.util.Scanner;

public class Home {
    void printMenu() {
        System.out.println("1) Play TV");
        System.out.println("2) Search Channels"); // DS is required here
        System.out.println("3) Record Shows");
        System.out.println("4) Display all available channels");
        System.out.println("5) Change Settings");
        System.out.println("6) Exit");
    }

    public void main(Scanner inp) throws SQLException, ClassNotFoundException {
        Misc.cls();
        System.out.println(Misc.ANSI_GREEN + "Login successfull" + Misc.ANSI_RESET);

        int index = 0;
        while (index != 6) {
            printMenu();
            index = Misc.checkInt(inp, "Enter choice: ");

            switch (index) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;

                default:
                    System.out.println("Enter correct index!!! ");
                    break;
            }
        }
    }
}
