import java.sql.SQLException;
import java.util.Scanner;

import DS.Misc;

public class Settings {
    void printMenu() {
        System.out.println("1) View Current data \n2) Change Username \n3) Change Password");
        System.out.println("4) Exit");
    }

    void main(Scanner inp, int id) throws SQLException, ClassNotFoundException {
        SQLQueries sq = new SQLQueries();

        int index = 0;
        while (index != 4) {
            printMenu();
            index = Misc.checkInt(inp, "Enter index: ");
            switch (index) {
                case 1:
                    Misc.cls();
                    sq.fetchcurrentSettings(id);
                    break;

                case 2:
                    Misc.cls();
                    inp.nextLine();
                    sq.changeUsername(inp);
                    break;

                case 3:
                    Misc.cls();
                    inp.nextLine();
                    sq.changeUserpassword(inp);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Enter correct index: ");
                    break;
            }
        }
    }

    // public static void main(String[] args) throws Exception {
    // Scanner sc = new Scanner(System.in);

    // System.out.print("Enter from below choices");
    // System.out.println("1.View Current data \n 2.Change Username \n 3.Change
    // Password");
    // int ch = sc.nextInt();
    // switch (ch) {
    // case 1:
    // sq.fetchcurrentSettings();
    // break;

    // case 2:
    // sq.changeUsername();
    // break;

    // case 3:
    // sq.changeUserpassword();
    // break;

    // default:
    // break;
    // }
    // sq.changeUserpassword();
    // }
}
