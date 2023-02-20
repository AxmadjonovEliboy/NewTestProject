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

    }

    public static void update() {

    }

    public static void getAll() {

    }

    public static void get() {

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
