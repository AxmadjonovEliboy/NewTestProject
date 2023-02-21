package service;

import db.MyDb;
import model.User;
import utils.Utils;

import java.util.Objects;

/**
 * @author Jarvis on Mon 23:19. 20/02/23
 */
public class UserService {


    public static void delete() {
        for (User user : MyDb.users) {

            if (!user.getDeleted()) {
                System.out.println(user);
            }
        }
        String choose = Utils.getString("O`chiriladigan username:");
        for (User user : MyDb.users) {
            if (user.getUsername().equals(choose)) {
                user.setDeleted(true);
            }
        }

    }

    public static void update() {
        for (User user : MyDb.users) {
            if (!user.getDeleted()) {
                System.out.println(user);
            }
        }
        String choose = Utils.getString("Update username choose:");
        for (User user : MyDb.users) {
            if (!user.getDeleted() && user.getUsername().equals(choose)) {
                String password = Utils.getString("Enter password:");
                if (password.equals(user.getPassword())) {

                    String fullName = Utils.getString("Enter new fullName:");
                    user.setFullName(fullName);

                    String username = Utils.getString("Enter new username:");
                    user.setUsername(username);

                    String newPassword = Utils.getString("Enter new password:");
                    user.setPassword(newPassword);

                    int age = Utils.getNum("Enter new age:");
                    user.setAge(age);

                } else {
                    Utils.println("Password xato kiritildi qaytadan urinib ko'r mag'ar");
                }
            }
        }
    }

    public static void getAll() {
        int counter = 1;
        for (User user : MyDb.users) {
            if (!user.getDeleted()) {
                System.out.println(counter + user.toString());
            }
            counter++;
        }
    }

    public static void get() {
        String choose = Utils.getString("Enter username:");
        for (User user : MyDb.users) {
            if (!user.getDeleted() && choose.equals(user.getUsername())) {
                System.out.println(user);
            }
        }
    }


    public static void register() {
        String fullName = Utils.getString("Enter fullName : ");
        String username = Utils.getString("Enter username : ");
        if (Objects.nonNull(MyDb.checkUsername(username))) return;
        String password = Utils.getString("Enter password : ");
        Integer age = Utils.getNum("Enter age : ");
        User user = new User(fullName, username, password, age);
        MyDb.addUser(user);

    }

    public static void login() {
        String username = Utils.getString("Enter username : ");
        String password = Utils.getString("Enter password : ");
        User user = MyDb.checkUsername(username);
        if (Objects.isNull(user)) {
            Utils.println("Bunday username yo`q !");
        } else if (user.getPassword().equals(password)) {
            MyDb.setSession(user);
        }

    }

    public static void logout() {
        MyDb.setSession(null);
    }

}
