package net.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "PERSON")
public class PersonEntity {
    @Id
    @Column(name = "ID_PERSON", nullable = false,unique = true)
    @NotNull
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BERTHDAY")
    @NotNull
    @Past
    private Date birthdate;

    public PersonEntity() {
    }

    public PersonEntity(@NotNull Long id,String name, @Past Date birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }


}

