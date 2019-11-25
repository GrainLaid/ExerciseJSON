package net.test.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="MODEL")
public class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_MODEL")
    private long id;

    @ManyToOne
    private CarEntity carEntity;

    @Column(name = "MODELS", nullable = false)
    @NotNull
    private String model;

    @OneToMany(cascade = CascadeType.ALL)
    private List<VendorEntity> vendorEntity = new ArrayList<>();


    public ModelEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CarEntity getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(CarEntity carEntity) {
        this.carEntity = carEntity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<VendorEntity> getVendorEntity() {
        return vendorEntity;
    }

    public void setVendorEntity(List<VendorEntity> vendorEntity) {
        this.vendorEntity = vendorEntity;
    }

}