package net.test.DTO;

import javax.validation.constraints.NotNull;
import java.util.List;

public class PersonWithCars {
    @NotNull
    long id;
    @NotNull
    String name;
    @NotNull
    String birthdate;
    List Cars;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

