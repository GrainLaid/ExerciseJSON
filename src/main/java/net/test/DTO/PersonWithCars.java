package net.test.DTO;

import java.util.List;

public class PersonWithCars {
    Long id;
    String name;
    String birthdate;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
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

