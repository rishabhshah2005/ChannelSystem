import java.sql.SQLException;
import java.util.Scanner;

import DS.Misc;

public class Settings {
    String user;
    int id;
    SQLQueries sq;

    public Settings(String user, int id, SQLQueries sq) {
        this.user = user;
        this.id = id;
        this.sq = sq;
    }

    public void reqPackChng(Scanner inp) throws SQLException {
        System.out.println("1) Free Channels.");
        System.out.println("2) HD Channels.");
        System.out.println("3) Normal Channels.");
        System.out.println("4) All Channels.");
        int new_id = Misc.checkInt(inp, "Enter the package you want to change to: ");
        while (!(new_id>0 && new_id<5)) {
            System.out.println("Enter correct index!!");
            new_id = Misc.checkInt(inp, "Enter the package you want to change to: ");
        }

        if (sq.checkRequest(user)) {
            Misc.cls();
            System.out.println(Misc.ANSI_RED + "Request is still pending" + Misc.ANSI_RESET);
        } else {
            sq.insertRequest(user, new_id);
            Misc.cls();
            System.out.println(Misc.ANSI_GREEN + "Request sent to admin" + Misc.ANSI_RESET);
        }
    }

    void printMenu() {
        System.out.println("1) View Current data \n2) Change Username \n3) Change Password");
        System.out.println("4) Request Package Change");
        System.out.println("5) Exit");
    }

    void main(Scanner inp) throws SQLException, ClassNotFoundException {

        int index = 0;
        Misc.cls();
        while (index != 5) {

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
                    reqPackChng(inp);
                    break;
                case 5:
                    Misc.cls();
                    break;
                default:
                    System.out.println("Enter correct index: ");
                    break;
            }
        }
    }

}
