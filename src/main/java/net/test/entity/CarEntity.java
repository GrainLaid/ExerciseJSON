package net.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CAR")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CAR")
    private Long id;

    @Column(name = "CAR_MODEL", nullable = false)
    @NotNull
    private String model;

    @Column(name = "HORSEPOWER", nullable = false)
    @NotNull
    @Min(1)
    private Integer horsepower;

    @Column(name = "OWNERID", nullable = false)
    @NotNull
    private Long ownerid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Person_Car", nullable = false)
    @JsonIgnore
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

