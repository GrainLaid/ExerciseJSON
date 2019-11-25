package net.test.DTO;

public class CarDTO {

    private Long id;
    private String model;
    private Integer horsepower;
    private long ownerId;

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

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}

