package net.test.controllers;


import net.test.DTO.PersonDTO;


import net.test.service.ServiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;


@Controller
public class PersonController {

    private ServiceEntity serviceEntity;

    @Autowired
    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public ResponseEntity personDTO(@RequestBody @Valid PersonDTO personDTO) {


        if (personDTO.getBirthdate() == null || personDTO.getName() == null || personDTO.getId() == 0) {
            return ResponseEntity.badRequest().build();
        }

        if (serviceEntity.idPersonValidate(personDTO.getId())) {
            return ResponseEntity.badRequest().build();
        }

        if (!(personDTO.getBirthdate().before(new Date()))) {
            return ResponseEntity.badRequest().build();
        }

        serviceEntity.personSave(personDTO.getId(), personDTO.getName(), personDTO.getBirthdate());
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @RequestMapping(value = "/clear")
    public ResponseEntity clearAll() {
        serviceEntity.clearAll();
        return ResponseEntity.ok().build();
    }

}
