import java.sql.SQLException;
import java.util.Scanner;

import DS.*;

public class AdminLogin {
    LinkedListPrac<PlayQue> curr_playing = new LinkedListPrac<>();
    LinkedListPrac<Integer> pack_chann = new LinkedListPrac<>();
    SQLQueries sq;
    int id;

    public AdminLogin(int id, SQLQueries quer) throws SQLException, ClassNotFoundException {
        sq = quer;
        this.id = id;
    }

    public void viewReqHistory() throws SQLException {
        LinkedListPrac<Req> llp = sq.getAllRequests();
        llp.displayReq();
    }

    public void decideOnRequests(Scanner inp) throws SQLException {
        Que<Req> res = sq.getPendingReqs();
        String[] headings = { "Username", "Requested Package" };
        int index = 0;
        Req q = res.deque();
        while (index != 3 && q != null) {
            Misc.cls();
            System.out.println(Misc.padAllRight(headings, 25, Misc.ANSI_YELLOW));
            String[] ans = { q.username, Misc.getPackageName(q.new_pack_id) };
            System.out.println(Misc.padAllRight(ans, 25));
            System.out.println();
            System.out.println("1) Accept");
            System.out.println("2) Reject");
            System.out.println("3) Exit");
            index = Misc.checkInt(inp, "Enter index: ");
            switch (index) {
                case 1:
                    sq.updateReq("accepted", q.username);
                    break;
                case 2:
                    sq.updateReq("rejected", q.username);
                    break;
                case 3:
                    break;
                default:
                    break;
            }
            q = res.deque();
        }
        if (q == null) {
            Misc.cls();
            System.out.println(Misc.ANSI_GREEN + "No pending requests" + Misc.ANSI_RESET);
        }
    }

    void printMenu() {
        System.out.println("1) Change user package");
        System.out.println("2) Update channel");
        System.out.println("3) View Request history");
        System.out.println("4) Accept or reject requests");
        System.out.println("5) Exit");
    }

    public void main(Scanner inp, int id) throws SQLException, ClassNotFoundException {
        Misc.cls();
        System.out.println(Misc.ANSI_YELLOW + "ADMIN LOGIN SUCCESSFUL!!!" + Misc.ANSI_RESET);
        int index = 0;
        while (index != 5) {
            printMenu();
            index = Misc.checkInt(inp, "Enter choice: ");

            switch (index) {

                case 1:
                    Misc.cls();
                    inp.nextLine();
                    System.out.print("Enter username to change user pack: ");
                    String username = inp.nextLine();
                    sq.changeUserPack(inp, username);
                    break;

                case 2:
                    Misc.cls();
                    inp.nextLine();
                    sq.updateChannel(inp);
                    break;
                case 3:
                    Misc.cls();
                    viewReqHistory();
                    break;
                case 4:
                    Misc.cls();
                    decideOnRequests(inp);
                    break;

                case 5:
                    Misc.cls();
                    break;

                default:
                    System.out.println("Enter correct index!!! ");
                    break;
            }
        }
    }
}
