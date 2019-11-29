package net.test.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Table(name = "PERSON")
public class PersonEntity {
    @Id
    @Column(name = "ID_PERSON", nullable = false, unique = true)
    @NotNull
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BERTHDAY")
    @NotNull
    @Past
    private Date birthdate;

    public PersonEntity() {
    }

    public PersonEntity(@NotNull long id, String name, @Past Date birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }


}

