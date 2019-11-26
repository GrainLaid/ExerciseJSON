package net.test.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="VENDOR")
public class VendorEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "vendorName")
    private String vendorName;

    @ManyToOne
    private ModelEntity modelEntity;

    public VendorEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public ModelEntity getModelEntity() {
        return modelEntity;
    }

    public void setModelEntity(ModelEntity modelEntity) {
        this.modelEntity = modelEntity;
    }
}