package net.test.DTO;

import java.util.List;

public class PersonWithCars {
    Long id;
    String name;
    String birthday;
    List Cars;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List getCars() {
        return Cars;
    }

    public void setCars(List cars) {
        Cars = cars;
    }

    public PersonWithCars() {
    }
}

