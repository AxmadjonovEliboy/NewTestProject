package service;

import db.MyDb;
import model.Course;
import utils.Utils;

public class CourseService {

    public static void allCourse() {
        int counter = 1;
        for (Course course : MyDb.courses) {
            if (!course.getDeleted()) {
                Utils.println(counter+" "+course);
                counter++;
            }
        }

    }

    public static void addCourse() {
        String courseName=Utils.getString("Course name enter:");
        double price=Utils.getNum("Course price:");

        boolean a = false;
        for (Course course : MyDb.courses) {
            if (course.getName().equals(courseName)) {
                a = true;
                break;
            }
        }
        if (!a) MyDb.courses.add(new Course(courseName, price));
    }

    public static void deleteCourse() {
    }

    public static void updateCourse() {
    }

    public static void myCourse() {
    }
}
