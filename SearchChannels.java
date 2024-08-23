import java.sql.SQLException;
import java.util.Scanner;
import DS.*;

public class SearchChannels {
    SQLQueries quer;
    LinkedListPrac<Integer> ll_pack;
    LinkedListPrac<PlayQue> all_channs;
    LinkedListPrac<PlayQue> result = new LinkedListPrac<PlayQue>();

    public SearchChannels(SQLQueries quer, LinkedListPrac<Integer> ll_pack) throws SQLException {
        this.quer = quer;
        this.ll_pack = ll_pack;
        all_channs = quer.AllChannels(ll_pack);
    }

    private void searchByName(Scanner inp) {
        System.out.print("Enter name of the channel: ");
        String name = inp.nextLine();
        LinkedListPrac<PlayQue> res = all_channs.searchByName(name);
        if (res.head == null) {
            System.out.println(Misc.ANSI_RED + "No Channel Found" + Misc.ANSI_RESET);
        } else {
            res.printChannels();
            result.addAll(res);
        }
        System.out.println("Press enter to exit");
        inp.nextLine();
    }

    private void searchByID(Scanner inp) {
        int id = Misc.checkInt(inp, "Enter ID of the channel: ");
        LinkedListPrac<PlayQue> res = all_channs.searchByID(id);
        if (res.head == null) {
            System.out.println(Misc.ANSI_RED + "No Channel Found" + Misc.ANSI_RESET);
        } else {
            res.printChannels();
            result.addAll(res);
        }
        System.out.println("Press enter to exit");
        inp.nextLine();
        inp.nextLine();
    }

    private void searchByLanguage(Scanner inp) {
        result.truncate();
        LinkedListPrac<PlayQue> res;

        System.out.println("Select language");
        System.out.println("1) Hindi");
        System.out.println("2) English");
        System.out.println("3) Gujrati");
        int index = Misc.checkInt(inp, "Enter index: ");

        switch (index) {
            case 1:
                res = all_channs.searchByLang("hindi");
                break;
            case 2:
                res = all_channs.searchByLang("english");
                break;
            case 3:
                res = all_channs.searchByLang("gujarati");
                break;
            default:
                Misc.cls();
                System.out.println("Enter correct index");
                return;
        }
        if (res.head == null) {
            System.out.println(Misc.ANSI_RED + "No Channel Found" + Misc.ANSI_RESET);
        } else {
            res.printChannels();
            result.addAll(res);
        }
        System.out.println("Press enter to exit");
        inp.nextLine();
        inp.nextLine();
    }

    private void searchByType(Scanner inp) {
        result.truncate();
        LinkedListPrac<PlayQue> res;

        System.out.println("Select type");
        System.out.println("1) Movies");
        System.out.println("2) Serials");
        System.out.println("3) News");
        System.out.println("4) Cartoons");
        System.out.println("5) Animation");
        System.out.println("6) Sports");
        System.out.println("7) Comedy");
        int index = Misc.checkInt(inp, "Enter index: ");

        switch (index) {
            case 1:
                res = all_channs.searchByType("movie");
                break;
            case 2:
                res = all_channs.searchByType("serial");
                break;
            case 3:
                res = all_channs.searchByType("news");
                break;
            case 4:
                res = all_channs.searchByType("cartoon");
                break;
            case 5:
                res = all_channs.searchByType("animation");
                break;
            case 6:
                res = all_channs.searchByType("sport");
                break;
            case 7:
                res = all_channs.searchByType("comedy");
                break;
            default:
                Misc.cls();
                System.out.println("Enter correct index");
                return;
        }

        System.out.println("Select language");
        System.out.println("1) Hindi");
        System.out.println("2) English");
        System.out.println("3) Gujrati");
        System.out.println("4) All");
        index = Misc.checkInt(inp, "Enter index: ");

        switch (index) {
            case 1:
                res = res.searchByLang("hindi");
                break;
            case 2:
                res = res.searchByLang("english");
                break;
            case 3:
                res = res.searchByLang("gujarati");
                break;
            case 4:
                break;
            default:
                Misc.cls();
                System.out.println("Enter correct index");
                return;
        }
        Misc.cls();
        if (res.head == null) {
            System.out.println(Misc.ANSI_RED + "No Channel Found" + Misc.ANSI_RESET);
        } else {
            res.printChannels();
            result.addAll(res);
        }
        System.out.println("Press enter to exit");
        inp.nextLine();
        inp.nextLine();

    }

    private void printMenu() {
        System.out.println("1) Search by name");
        System.out.println("2) Search by Channel Number");
        System.out.println("3) Search by Channel Type");
        System.out.println("4) Search by Language");
        System.out.println("5) Start Playing");
        System.out.println("6) Exit");
    }

    public LinkedListPrac<PlayQue> main(Scanner inp) {
        int index = 0;
        while (index != 6) {
            Misc.cls();
            printMenu();
            index = Misc.checkInt(inp, "Enter Index: ");
            switch (index) {
                case 1:
                    Misc.cls();
                    inp.nextLine();
                    searchByName(inp);
                    break;
                case 2:
                    Misc.cls();
                    searchByID(inp);
                    break;
                case 3:
                    Misc.cls();
                    searchByType(inp);
                    break;
                case 4:
                    Misc.cls();
                    searchByLanguage(inp);
                    break;
                case 5:
                    Misc.cls();
                    if (result.head == null) {
                        Misc.cls();
                        System.out.println(Misc.ANSI_RED + "QUEUE IS EMPTY" + Misc.ANSI_RESET);
                        System.out.println("Press enter to exit");
                        inp.nextLine();
                        inp.nextLine();

                        break;
                    }
                    result.playTV(inp);
                    break;
                case 6:
                    Misc.cls();
                    break;

                default:
                    System.out.println("Enter correct index");
                    break;
            }
        }
        return result;
    }

}
