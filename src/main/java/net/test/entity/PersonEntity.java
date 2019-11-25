package net.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name = "PERSON")
public class PersonEntity {
    @Id
    @Column(name = "ID_PERSON", nullable = false, unique = true)
    @NotNull
    private Long id;

    @Column(name = "NAME", nullable = false)
    @NotNull
    @Size(min = 2, max = 30, message = "Именя не может быть меньше 2х знаков и не более 30")
    private String name;

    @Column(name = "BERTHDAY")
    @NotNull
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date birthday;

    public PersonEntity() {
    }

    public PersonEntity(@NotNull Long id, @NotNull @Size(min = 2, max = 30, message = "Именя не может быть меньше 2х знаков и не более 30") String name, @NotNull @Past Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


}

