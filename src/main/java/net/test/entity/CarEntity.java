package net.test.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CAR")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_CAR")
    private Long id;

    @Column(name = "CAR_MODEL", nullable = false)
    @NotNull
    private String model;

    @Column(name = "HORSEPOWER", nullable = false)
    @NotNull
    private Integer horsepower;

    @Column(name = "OWNERID", nullable = false)
    @NotNull
    private Long ownerid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Person_Car", nullable = false)
    private PersonEntity personEntity;

    public CarEntity() {
    }

    public CarEntity(String model, Integer horsepower, Long ownerid) {
        this.model = model;
        this.horsepower = horsepower;
        this.ownerid = ownerid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }
}

