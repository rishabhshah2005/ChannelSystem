import java.sql.SQLException;
import java.util.Scanner;

import DS.Misc;

public class Main {
    int current_user_id;

    public static void printMenu() {
        System.out.println("1) Login");
        System.out.println("2) SignUp");
        System.out.println("3) Exit");
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner inp = new Scanner(System.in);
        SQLQueries quer = new SQLQueries();

        Misc.cls();
        Misc.welcome();

        int index = 0;
        while (index != 3) {
            printMenu();

            index = Misc.checkInt(inp, "Enter index: ");

            switch (index) {
                case 1:
                    System.out.print("Enter username: ");
                    inp.nextLine();
                    String user = inp.nextLine();
                    System.out.print("Enter password: ");
                    String pass = inp.nextLine();
                    int current_user_id = quer.checkUsernamePass(user, pass);
                    if (current_user_id == 0) {
                        Misc.cls();
                        System.out.println(Misc.ANSI_RED + "Login failed!!!" + Misc.ANSI_RESET);
                    } else {
                        if (user.equals("admin")) {
                            System.out.println(Misc.ANSI_YELLOW + "ADMIN LOGIN SUCCESSFUL!!!" + Misc.ANSI_RESET);
                            // If user is admin then a special class has to run
                        } else {
                            // Whatever classes are supposed to run after login is successfull go below
                            Home h = new Home(current_user_id, quer);
                            h.main(inp, current_user_id);
                        }
                    }
                    break;
                case 2:
                    inp.nextLine();
                    Misc.cls();
                    quer.createUser(inp);
                    break;

                case 3:
                    quer.con.close();
                    break;

                default:
                    System.out.println("Enter correct index!!");
                    break;
            }
        }
        inp.close();
        quer.con.close();
    }
}