import db.MyDb;
import service.UserService;
import utils.Utils;

import java.util.Objects;


/**
 * @author Jarvis on ${DAY_NAME_SHORT} ${TIME}. ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {

        if (Objects.isNull(MyDb.getSession())) {
            login();
            String choice = Utils.getString("?: ");
            switch (choice) {
                case "1" -> UserService.register();
                case "2" -> UserService.login();
                case "3" -> {
                    Utils.println("Good by 😢");
                    return;
                }
                default -> Utils.println("To`g`ri tanlang bro  🙄 ");
            }

        } else {
            theme();
            String choice = Utils.getString("?: ");
            switch (choice) {
                case "1" -> UserService.get();
                case "2" -> UserService.getAll();
                case "3" -> UserService.update();
                case "4" -> UserService.delete();
                case "5" -> UserService.logout();
                default -> Utils.println("To`g`ri tanlang bro 🙄 ");

            }
        }
        run();

    }

    public static void theme() {
        Utils.println("1 -> get");
        Utils.println("2 -> getAll");
        Utils.println("3 -> update");
        Utils.println("4 -> delete");
        Utils.println("5 -> logout");
    }

    public static void login() {
        Utils.println("1 -> register");
        Utils.println("2 -> login");
        Utils.println("3 -> exit");
    }
}