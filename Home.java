import java.sql.SQLException;
import java.util.Scanner;
import DS.LinkedListPrac;

public class Home {
    LinkedListPrac<PlayQue> curr_playing = new LinkedListPrac<>();
    LinkedListPrac<Integer> pack_chann = new LinkedListPrac<>();
    SQLQueries quer;
    int id;

    public Home(int id, SQLQueries quer) throws SQLException, ClassNotFoundException {
        this.quer = quer;
        this.id = id;
        quer.getPackage(id, pack_chann);
    }

    void printMenu() {
        System.out.println("1) Play TV");
        System.out.println("2) Search Channels");
        System.out.println("3) Record Shows");
        System.out.println("4) Display all available channels");
        System.out.println("5) Change Settings");
        System.out.println("6) Exit");
    }

    public void displayAll(Scanner inp) throws SQLException {
        curr_playing = quer.displayAllChannels(pack_chann);
        int index = 0;
        while (index != 3) {
            Misc.cls();
            curr_playing.display();
            System.out.println();
            System.out.println("1) Next");
            System.out.println("2) Prev");
            System.out.println("3) Exit");
            index = Misc.checkInt(inp, "Enter index: ");
            switch (index) {
                case 1:
                    curr_playing.next();
                    break;
                case 2:
                    curr_playing.prev();
                    break;
                case 3:
                    Misc.cls();
                    break;

                default:
                    System.out.println("Enter correct index!!");
                    break;
            }
        }

    }

    public void main(Scanner inp, int id) throws SQLException, ClassNotFoundException {
        Misc.cls();
        System.out.println(Misc.ANSI_GREEN + "Login successfull" + Misc.ANSI_RESET);

        int index = 0;
        while (index != 6) {
            printMenu();
            index = Misc.checkInt(inp, "Enter choice: ");

            switch (index) {
                case 1:
                    curr_playing.display();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    displayAll(inp);
                    break;
                case 5:
                    Settings st = new Settings();
                    st.main(inp, id);
                    break;
                case 6:
                    Misc.cls();
                    break;

                default:
                    System.out.println("Enter correct index!!! ");
                    break;
            }
        }
    }
}
