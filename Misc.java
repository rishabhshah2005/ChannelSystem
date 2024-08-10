import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class UserDeleted extends Exception {
}

class Misc {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Exception in cls()");
            System.out.println(e);
        }
    }

    public static String leftPadding(String input, char ch, int L) {

        String result = String.format("%" + L + "s", input).replace(' ', ch);

        // Return the resultant string
        return result;
    }

    // Function to perform right padding
    public static String rightPadding(String input, char ch, int L) {

        String result = String.format("%" + (-L) + "s", input).replace(' ', ch);

        // Return the resultant string
        return result;
    }

    public static String padAllRight(String[] arr, int L) {
        String res = "";
        for (String string : arr) {
            string = String.format("%-" + L + "s", string);
            res += string;
        }
        return res;
    }

    public static String padAllRight(String[] arr, int L, String color) {
        String res = "";
        for (String string : arr) {
            string = String.format("%-" + L + "s", string);
            res += string;
        }
        return color + res + "\u001B[0m";
    }

    public static Timestamp convert(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Date parsedDate = sdf.parse(date);
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        return timestamp;

    }

    public static void welcome() {
        System.out.println(ANSI_GREEN + "__          __  ______   _         _____    ____    __  __   ______ \r\n" + //
                " \\ \\        / / |  ____| | |       / ____|  / __ \\  |  \\/  | |  ____|\r\n" + //
                "  \\ \\  /\\  / /  | |__    | |      | |      | |  | | | \\  / | | |__   \r\n" + //
                "   \\ \\/  \\/ /   |  __|   | |      | |      | |  | | | |\\/| | |  __|  \r\n" + //
                "    \\  /\\  /    | |____  | |____  | |____  | |__| | | |  | | | |____ \r\n" + //
                "     \\/  \\/     |______| |______|  \\_____|  \\____/  |_|  |_| |______|" + ANSI_RESET);
    }

    public static int checkInt(Scanner inp, String s) {
        int n = 0;
        try {
            System.out.print(s);
            n = inp.nextInt();
        } catch (Exception e) {
            System.out.println("Input Type not supported");
            inp.nextLine();
            return checkInt(inp, s);
        }
        return n;
    }
}
