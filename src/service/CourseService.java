package service;

import db.MyDb;
import model.Course;
import utils.Utils;

import java.util.Objects;

public class CourseService {
    public static boolean isFound = false;
    public static int counter = 1;

    public static void allCourse() {
        counter = 1;
        for (Course course : MyDb.courses) {
            if (!course.getDeleted()) {
                Utils.println(counter + ") " + course);
                counter++;
            }
        }

    }

    public static void addCourse() {
        String courseName = Utils.getString("Course name enter:");
        double price = Utils.getNum("Course price:");

        isFound = false;
        for (Course course : MyDb.courses) {
            if (course.getName().equals(courseName)) {
                Utils.println(Utils.ANSI_YELLOW_BACKGROUND + Utils.ANSI_RED + "This course is available" + Utils.ANSI_RESET);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            MyDb.courses.add(new Course(courseName, price));
            Utils.printSuccessful();
        }
    }

    public static void deleteCourse() {
        counter = 1;
        for (Course course : MyDb.courses) {
            if (!course.getDeleted()) {
                Utils.println(counter + ") " + course);
                counter++;
            }
        }
        isFound = false;
        String choice = Utils.getString("Choice delete course name: ");
        for (Course course : MyDb.courses) {
            if (!course.getDeleted() && course.getName().equals(choice)) {
                course.setDeleted(true);
                Utils.printSuccessful();
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            Utils.printNotFound();
        }
    }

    public static void updateCourse() {
        counter = 1;
        for (Course course : MyDb.courses) {
            if (!course.getDeleted()) {
                Utils.println(counter + ") " + course);
                counter++;
            }
        }
        String choose = Utils.getString("Choice update course name: ");
        if (Objects.isNull(MyDb.checkCourse(choose))) {
            Utils.printNotFound();
        } else {
            Utils.println("1-> Course name update");
            Utils.println("2-> Course price update");
            int choice = Utils.getNum(".? ");
            if (choice == 1) {
                updateCourseName(choose);
            } else if (choice == 2) {
                updateCoursePrice(choose);
            } else {
                Utils.println("Xato qiymat kiritdingiz bor");
                updateCourse();
            }
        }

    }

    private static void updateCoursePrice(String oldCourseName) {
        double newCoursePrice = Utils.getNum("Enter new Course price:");
        for (Course course : MyDb.courses) {
            if (!course.getDeleted() && course.getName().equals(oldCourseName)) {
                course.setPrice(newCoursePrice);
                Utils.printSuccessful();
                break;
            }
        }
    }

    private static void updateCourseName(String oldCourseName) {
        String newCourseName = Utils.getString("Enter new Course name:");
        for (Course course : MyDb.courses) {
            if (!course.getDeleted() && course.getName().equals(oldCourseName)) {
                course.setName(newCourseName);
                Utils.printSuccessful();
                break;
            }
        }
    }

    public static void myCourse() {
        Utils.println("1 -> my courses");
        Utils.println("2 -> add my courses");
        Utils.println("3 -> delete my courses");
        int choice = Utils.getNum(".?");
        switch (choice) {
            case 1 -> myCourses();
            case 2 -> addMyCourses();
            case 3 -> deleteMyCourses();
            default -> myCourse();
        }
    }

    private static void deleteMyCourses() {
        isFound = false;
        myCourses();
        String choice_course = Utils.getString("Enter ");
        for (Course course : MyDb.getSession().getCourses()) {
            if (!course.getDeleted() && course.getTake() && course.getName().equals(choice_course)) {
                course.setTake(false);
                Utils.printSuccessful();
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            Utils.printNotFound();
        }
    }

    private static void addMyCourses() {
        counter = 1;
        for (Course course : MyDb.courses) {
            if (!course.getDeleted() && !course.getTake()) {
                System.out.println(course);
                counter++;
            }
        }
        isFound = false;
        String choice_course = Utils.getString("Enter course name : ");
        for (Course course : MyDb.courses) {
            if (!course.getDeleted() && !course.getTake()&&course.getName().equals(choice_course)) {
                MyDb.getSession().getCourses().add(course);
                course.setTake(true);
                Utils.printSuccessful();
                isFound = true;
            }
        }
        if (!isFound) {
            Utils.printNotFound();
        }
    }

    private static void myCourses() {
        counter = 1;
        for (Course course : MyDb.getSession().getCourses()) {
            if (!course.getDeleted() && course.getTake()) {
                System.out.println(counter + ") " + course);
                counter++;
            }
        }
        if (counter==1){
            Utils.println(Utils.ANSI_RED_BACKGROUND+Utils.ANSI_BLACK+" Empty "+Utils.ANSI_RESET);
        }
    }

}
