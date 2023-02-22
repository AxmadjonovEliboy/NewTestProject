package utils;

import java.util.Scanner;
import java.util.UUID;

/**
 * @author Jarvis on Mon 22:42. 20/02/23
 */
public class Utils {

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


}
