package net.test.controllers;

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
    public ResponseEntity carDTO(@RequestBody CarDTO carDTO) {
        if (carDTO.carVald()) {
            return ResponseEntity.badRequest().build();
        }
        PersonDTO personDTO = serviceEntity.retunrPerson(carDTO.getOwnerId());
        if (personDTO == null) {
            return ResponseEntity.badRequest().build();
        }
        if (serviceEntity.idCarValidate(carDTO.getId())) {
            return ResponseEntity.badRequest().build();
        }
        GregorianCalendar thisCalendar = new GregorianCalendar();
        GregorianCalendar birthdatePerson = new GregorianCalendar();
        birthdatePerson.setTime(personDTO.getBirthdate());
        Long milisecond = thisCalendar.getTimeInMillis() - birthdatePerson.getTimeInMillis();
        if (milisecond < 567648000000L) {
            return ResponseEntity.badRequest().build();
        }
        serviceEntity.carSave(carDTO.getId(), carDTO.getModel(), carDTO.getHorsepower(), carDTO.getOwnerId());
        return ResponseEntity.ok().build();
    }
}
