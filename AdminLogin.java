import java.sql.SQLException;
import java.util.Scanner;

import DS.LinkedListPrac;
import DS.Misc;
import DS.PlayQue;

public class AdminLogin {
    LinkedListPrac<PlayQue> curr_playing = new LinkedListPrac<>();
    LinkedListPrac<Integer> pack_chann = new LinkedListPrac<>();
    SQLQueries sq;
    int id;

    public AdminLogin(int id, SQLQueries quer) throws SQLException, ClassNotFoundException {
        sq = quer;
        this.id = id;
    }

    void printMenu() {
        System.out.println("1) Change user package");
        System.out.println("2) Update channel");
        System.out.println("3) Exit");
    }

    public void main(Scanner inp, int id) throws SQLException, ClassNotFoundException {
        Misc.cls();
        int index = 0;
        while (index != 3) {
            printMenu();
            index = Misc.checkInt(inp, "Enter choice: ");

            switch (index) {

                case 1:
                    Misc.cls();
                    System.out.println("Enter user id to change user pack");
                    int u_id = inp.nextInt();
                    inp.nextLine();
                    sq.changeUserPack(inp, u_id);
                    break;

                case 2:
                    Misc.cls();
                    sq.updateChannel(inp);
                    break;

                case 3:
                    Misc.cls();
                    break;

                default:
                    System.out.println("Enter correct index!!! ");
                    break;
            }
        }
    }
}
