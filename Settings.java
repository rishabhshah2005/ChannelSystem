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
        Misc.cls();
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
                    Misc.cls();
                    break;
                default:
                    System.out.println("Enter correct index: ");
                    break;
            }
        }
    }

}
