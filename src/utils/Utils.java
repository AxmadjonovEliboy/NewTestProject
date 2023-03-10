package utils;

import java.util.Scanner;
import java.util.UUID;

/**
 * @author Jarvis on Mon 22:42. 20/02/23
 */
public class Utils {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final Scanner SCANNER_NUM = new Scanner(System.in);
    private static final Scanner SCANNER_STR = new Scanner(System.in);

    public static String getId() {
        return UUID.randomUUID().toString();
    }

    public static String getString(String str) {
        System.out.print(str);
        return SCANNER_STR.nextLine();
    }

    public static Integer getNum(String str) {
        System.out.print(str);
        return SCANNER_NUM.nextInt();
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void print(String str) {
        System.out.print(str);
    }
    public static void printSuccessful(){
        println(Utils.ANSI_GREEN_BACKGROUND + Utils.ANSI_BLACK + " Successful " + Utils.ANSI_RESET);
    }
    public static void printNotFound(){
        println(Utils.ANSI_RED_BACKGROUND + Utils.ANSI_BLACK + " Not found! " + Utils.ANSI_RESET);
    }
    }
