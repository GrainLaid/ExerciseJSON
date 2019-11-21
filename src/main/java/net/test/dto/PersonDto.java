package net.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.test.entity.CarEntity;
import org.hibernate.boot.MappingException;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class PersonDto {

    @Id
    private  Long id;
    @NotNull
    private String name;
    @NotNull
    private String birthday;
    @JsonIgnore
    private List<CarEntity> carEntitiesList;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
