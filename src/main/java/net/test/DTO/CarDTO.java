package net.test.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CarDTO {
    @NotNull
    private long id;
    @NotNull
    private String model;
    @NotNull
    @Min(1)
    private Integer horsepower;
    @NotNull
    private long ownerId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}

