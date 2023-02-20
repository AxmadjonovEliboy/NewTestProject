package db;

import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jarvis on Mon 23:04. 20/02/23
 */
public class MyDb {
    public static List<User> users = new ArrayList<>();
    private static User session;

    public static User checkUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static User getSession() {
        return session;
    }

    public static void setSession(User user) {
        session = user;
    }

    public static void addUser(User user) {
        users.add(user);
    }


}
