package net.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CAR")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CarEntity {
    @Id
    @Column(name = "ID_CAR", nullable = false, unique = true)
    @NotNull
    private Long id;

    @Column(name = "HORSEPOWER", nullable = false)
    @NotNull
    @Min(1)
    private Integer horsepower;

    @Column(name = "OWNERID", nullable = false)
    @NotNull
    private Long ownerId;

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

    public CarEntity(@NotNull Long id, List modelEntity, @NotNull @Min(1) Integer horsepower, @NotNull Long ownerId) {
        this.id = id;
        this.modelEntity = modelEntity;
        this.horsepower = horsepower;
        this.ownerId = ownerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

}

