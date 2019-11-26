package net.test.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.test.DTO.CarDTO;
import net.test.DTO.PersonDTO;

import net.test.service.ServiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.GregorianCalendar;

@RestController
public class CarController {

    private ServiceEntity serviceEntity;

    @Autowired
    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public ResponseEntity carDTO(
            @RequestBody String json
    ) {
        Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy").create();
        CarDTO carDTO = new CarDTO();
        carDTO = gson.fromJson(json, CarDTO.class);
        PersonDTO personDTO = new PersonDTO();
        GregorianCalendar thisCalendar = new GregorianCalendar();
        GregorianCalendar birthdayPerson = new GregorianCalendar();
        birthdayPerson.setTime(personDTO.getBirthday());
        Long milisecond = thisCalendar.getTimeInMillis() - birthdayPerson.getTimeInMillis();
        if (milisecond < 567648000000L) {
            return ResponseEntity.badRequest().build();
        }
        serviceEntity.carSave(carDTO.getId(), carDTO.getModel(), carDTO.getHorsepower(), carDTO.getOwnerId());
        return ResponseEntity.ok().build();
    }
}
