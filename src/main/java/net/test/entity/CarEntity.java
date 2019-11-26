package net.test.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CAR")
public class CarEntity {
    @Id
    @Column(name = "ID_CAR")
    private long id;

    @Column(name = "HORSEPOWER", nullable = false)
    @NotNull
    @Min(1)
    private Integer horsepower;

    @Column(name = "OWNERID", nullable = false)
    @NotNull
    private long ownerId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ModelEntity> modelEntity = new ArrayList<>();

    public List<ModelEntity> getModelEntity() {
        return modelEntity;
    }

    public void setModelEntity(List<ModelEntity> modelEntity) {
        this.modelEntity = modelEntity;
    }


    public CarEntity() {
    }

    public CarEntity(long id, List modelEntity, @NotNull @Min(1) Integer horsepower, @NotNull long ownerId) {
        this.id = id;
        this.modelEntity = modelEntity;
        this.horsepower = horsepower;
        this.ownerId = ownerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

}

