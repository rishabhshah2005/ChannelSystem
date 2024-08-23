package DS;

import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Misc {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GRAY = "\u001B[90m";

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Exception in cls()");
            System.out.println(e);
        }
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

    public static boolean checkTimeIsInBetween(LocalTime input, LocalTime start, LocalTime end) {
        return input.isAfter(start) && input.isBefore(end);
    }

    public static String printTime(LocalTime t) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a");
        String res = dtf.format(t).toUpperCase();
        return res;

    }

    // public static void main(String[] args) {
    // LocalTime t = LocalTime.now();
    // System.out.println(printTime(t));
    // }
}


