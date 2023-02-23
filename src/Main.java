import db.MyDb;
import service.CourseService;
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
                default -> Utils.println("To`g`ri tanla mag'ar  🙄 ");
            }

        } else {
            theme();
            String choice = Utils.getString("?: ");
            switch (choice) {
                case "1" -> UserService.get();
                case "2" -> UserService.getAll();
                case "3" -> UserService.update();
                case "4" -> UserService.delete();
                case "5" -> courses();
                case "6" -> UserService.logout();
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
        Utils.println("5 -> courses");
        Utils.println("6 -> logout");
    }

    public static void login() {
        Utils.println("1 -> register");
        Utils.println("2 -> login");
        Utils.println("3 -> exit");
    }

    public static void courses() {

        Utils.println("1 -> all course");
        Utils.println("2 -> add course");
        Utils.println("3 -> delete course");
        Utils.println("4 -> update course");
        Utils.println("5 -> my course");
        Utils.println("6 -> back");

        String choice = Utils.getString("?: ");
        switch (choice) {
            case "1" -> CourseService.allCourse();
            case "2" -> CourseService.addCourse();
            case "3" -> CourseService.deleteCourse();
            case "4" -> CourseService.updateCourse();
            case "5" -> CourseService.myCourse();
            case "6" -> {
                run();
            }
            default -> Utils.println("To`g`ri tanlang bro 🙄 ");

        }
    }
}