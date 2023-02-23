package service;

import db.MyDb;
import model.User;
import utils.Utils;

import java.util.Objects;

/**
 * @author Jarvis on Mon 23:19. 20/02/23
 */
public class UserService {
    public static boolean isFound = false;

    public static void delete() {
        for (User user : MyDb.users) {
            if (!user.getDeleted()) {
                System.out.println(user);
            }
        }
        isFound = false;
        String choose = Utils.getString("Delete username choice:");
        for (User user : MyDb.users) {
            if (!user.getDeleted() && user.getUsername().equals(choose)) {
                user.setDeleted(true);
                isFound = true;
                Utils.printSuccessful();
                break;
            }
        }
        if (!isFound) {
            Utils.printNotFound();
        }

    }

    public static void update() {
        isFound = false;
        for (User user : MyDb.users) {
            if (!user.getDeleted()) {
                System.out.println(user);
            }
        }
        String choose = Utils.getString("Update username choose:");
        for (User user : MyDb.users) {
            if (!user.getDeleted() && user.getUsername().equals(choose)) {
                isFound = true;
                String password = Utils.getString("Enter password:");
                if (password.equals(user.getPassword())) {
                    Utils.println("1 -> edit Full name");
                    Utils.println("2 -> edit username");
                    Utils.println("3 -> edit password");
                    Utils.println("4 -> edit age");
                    Utils.println("5 -> back");
                    String choice_update = Utils.getString("-> ? ");
                    switch (choice_update) {
                        case "1" -> editFullName(user.getUsername());
                        case "2" -> editUsername(user.getUsername());
                        case "3" -> editPassword(user.getUsername());
                        case "4" -> editAge(user.getUsername());
                        case "5" -> update();
                    }

                } else {
                    Utils.println(Utils.ANSI_RED_BACKGROUND + Utils.ANSI_BLACK + "Password xato kiritildi qaytadan urinib ko'r mag'ar" + Utils.ANSI_RESET);
                }
            }
        }
        if (!isFound) {
            Utils.printNotFound();
        }
    }

    private static void editAge(String user) {
        int newAge = Utils.getNum("Enter new age:");
        for (User user1 : MyDb.users) {
            if (!user1.getDeleted() && user1.getUsername().equals(user)) {
                user1.setAge(newAge);
                Utils.printSuccessful();
                break;
            }
        }
    }

    private static void editPassword(String user) {
        String newPassword = Utils.getString("Enter new password:");
        for (User user1 : MyDb.users) {
            if (!user1.getDeleted() && user1.getUsername().equals(user)) {
                user1.setPassword(newPassword);
                Utils.printSuccessful();
                break;
            }
        }
    }

    private static void editUsername(String user) {
        String new_username = Utils.getString("Enter new username:");
        for (User user1 : MyDb.users) {
            if (!user1.getDeleted() && user1.getUsername().equals(user)) {
                if (Objects.isNull(MyDb.checkUsername(new_username))){
                    user1.setUsername(new_username);
                    Utils.printSuccessful();
                    break;
                }else {
                    Utils.println(Utils.ANSI_RED_BACKGROUND+Utils.ANSI_BLACK+"This username is busy"+Utils.ANSI_RESET);
                }
            }
        }
    }

    private static void editFullName(String user) {
        String fullName = Utils.getString("Enter new fullName:");
        for (User user1 : MyDb.users) {
            if (!user1.getDeleted() && user1.getUsername().equals(user)) {
                user1.setFullName(fullName);
                Utils.printSuccessful();
                break;
            }
        }
    }

    public static void getAll() {
        int counter = 1;
        if (MyDb.users.isEmpty()) {
            Utils.println(Utils.ANSI_YELLOW_BACKGROUND + Utils.ANSI_RED + " No users available " + Utils.ANSI_RESET);
        }
        for (User user : MyDb.users) {
            if (!user.getDeleted()) {
                System.out.println(counter + user.toString());
                counter++;
            }
        }
    }

    public static void get() {
        String choose = Utils.getString("Enter username:");
        isFound = false;
        for (User user : MyDb.users) {
            if (!user.getDeleted() && choose.equals(user.getUsername())) {
                System.out.println(user);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            Utils.printNotFound();
        }
    }

    public static void register() {
        String fullName = Utils.getString("Enter fullName : ");
        String username = Utils.getString("Enter username : ");
        if (Objects.nonNull(MyDb.checkUsername(username))) {
            Utils.println(Utils.ANSI_RED_BACKGROUND + Utils.ANSI_BLACK + " This username is busy " + Utils.ANSI_RESET);
            return;
        }
        String password = Utils.getString("Enter password : ");
        Integer age = Utils.getNum("Enter age : ");
        User user = new User(fullName, username, password, age);
        MyDb.addUser(user);
        Utils.printSuccessful();
    }

    public static void login() {
        String username = Utils.getString("Enter username : ");
        String password = Utils.getString("Enter password : ");
        User user = MyDb.checkUsername(username);
        if (Objects.isNull(user)) {
            Utils.printNotFound();
        } else if (user.getPassword().equals(password)) {
            Utils.printSuccessful();
            MyDb.setSession(user);
        }else{
            Utils.println(Utils.ANSI_RED_BACKGROUND+Utils.ANSI_BLACK+" Error password "+Utils.ANSI_RESET);
        }

    }

    public static void logout() {
        MyDb.setSession(null);
    }

}
