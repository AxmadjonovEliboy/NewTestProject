package model;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jarvis on Mon 00:16. 20/02/23
 */
public class User {
    private String id;

    private String fullName;

    private String username;

    private String password;

    private Integer age;

    private List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    private Boolean deleted = false;

    public User() {
    }

    public User(String fullName, String username, String password, Integer age) {
        this.id = Utils.getId();
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                " fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

}
