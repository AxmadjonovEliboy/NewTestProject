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

    static {
        users.add(new User("Jarvis", "jarvis", "777", 21));
        users.add(new User("Friday", "friday", "555", 22));
        users.add(new User("Monday", "monday", "222", 20));
    }

    public static User checkUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username) && !user.getDeleted()) {
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
