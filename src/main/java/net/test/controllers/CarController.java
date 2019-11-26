package net.test.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
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
    public ResponseEntity carDTO(@RequestBody String json)
    {
        Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy").create();
        CarDTO carDTO = new CarDTO();
        try {
            carDTO = gson.fromJson(json, CarDTO.class);
        } catch (JsonSyntaxException e) {
            return ResponseEntity.badRequest().build();
        }
        if (carDTO.getModel() == null){
            return ResponseEntity.badRequest().build();
        }
        if (carDTO.getHorsepower() == null){
            return ResponseEntity.badRequest().build();
        }

        if (carDTO.getModel().equals("")
                || carDTO.getHorsepower() == 0
                || carDTO.getId() == 0
                || carDTO.getOwnerId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        PersonDTO person = serviceEntity.retunrPerson(carDTO.getOwnerId());
        if (person == null) {
            return ResponseEntity.badRequest().build();
        }
        if (serviceEntity.idCarValidate(carDTO.getId()))
        {
            return ResponseEntity.badRequest().build();
        }
        if (carDTO.getModel().charAt(0)== '-'){
            return ResponseEntity.badRequest().build();
        }
        if (!(carDTO.getHorsepower() > 0)) {
            return ResponseEntity.badRequest().build();
        }

        GregorianCalendar thisCalendar = new GregorianCalendar();
        GregorianCalendar birthdatePerson = new GregorianCalendar();
        birthdatePerson.setTime(person.getBirthdate());
        Long milisecond = thisCalendar.getTimeInMillis() - birthdatePerson.getTimeInMillis();
        if (milisecond < 567648000000L) {
            return ResponseEntity.badRequest().build();
        }
        serviceEntity.carSave(carDTO.getId(), carDTO.getModel(), carDTO.getHorsepower(), carDTO.getOwnerId());
        return ResponseEntity.ok().build();
    }
}
