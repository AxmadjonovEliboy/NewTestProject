package model;

import utils.Utils;

/**
 * @author Jarvis on Mon 22:35. 20/02/23
 */
public class Course {

    private String id;
    private String name;
    private Double price;
    private Boolean isTake;

    private Boolean deleted;

    public Course() {
    }

    public Course(String name, Double price, Boolean isTake, Boolean deleted) {
        this.id = Utils.getId();
        this.name = name;
        this.price = price;
        this.isTake = isTake;
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getTake() {
        return isTake;
    }

    public void setTake(Boolean take) {
        isTake = take;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Course{" +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isTake=" + isTake +
                '}';
    }
}
