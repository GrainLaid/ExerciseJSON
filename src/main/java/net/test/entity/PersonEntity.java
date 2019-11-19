package net.test.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "PERSON")
public class PersonEntity {
    @Id
    @Column(name = "ID_PERSON", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @Column(name = "NAME", nullable = false)
    @NotNull
    @Size(min = 2, max = 30, message = "Именя не может быть меньше 2х знаков и не более 30")
    private String name;

    @Column(name = "BERTHDAY")
    @NotNull
    private String birthday;

    @OneToMany(mappedBy = "PERSONS", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CarEntity> carEntitiesList;

    public PersonEntity() {
    }

    public PersonEntity(String name, String birthday) {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<CarEntity> getCarEntitiesList() {
        return carEntitiesList;
    }

    public void setCarEntitiesList(List<CarEntity> carEntitiesList) {
        this.carEntitiesList = carEntitiesList;
    }

}

