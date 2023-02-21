package db;

import model.Course;
import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jarvis on Mon 23:04. 20/02/23
 */
public class MyDb {
    public static List<User> users = new ArrayList<>();
    public static List<Course> courses = new ArrayList<>();
    private static User session;

    static {
        users.add(new User("Jarvis", "jarvis", "777", 21));
        users.add(new User("Friday", "friday", "555", 22));
        users.add(new User("Monday", "monday", "222", 20));
    }

    static {
        courses.add(new Course("Java", 1400.00));
        courses.add(new Course("Python", 1200.00));
        courses.add(new Course("C#", 1000.00));
        courses.add(new Course("C++", 1300.00));
        courses.add(new Course("PHP", 900.00));
        courses.add(new Course("C", 1000.00));
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
