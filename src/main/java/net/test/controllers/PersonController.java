package net.test.controllers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import net.test.DTO.PersonDTO;


import net.test.service.ServiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



@Controller
public class PersonController {

    private ServiceEntity serviceEntity;

    @Autowired
    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public ResponseEntity personDTO(@RequestBody String json)
    {

        Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy").create();

        PersonDTO personDTO = new PersonDTO();
        if (json != null) {
            int i = json.length();
            char[] characters = new char[10];
            json.getChars(i - 12, i - 2, characters, 0);
            String wtf = String.valueOf(characters);
            System.out.println(wtf);

            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            df.setLenient(false);
            try {
                Date date = df.parse(wtf);
                System.out.println(date);
            } catch (ParseException e) {
                return ResponseEntity.badRequest().build();
            }
        }
        try {
            personDTO = gson.fromJson(json, PersonDTO.class);
        } catch (JsonSyntaxException e) {
            return ResponseEntity.badRequest().build();
        }

        if (personDTO.getBirthdate() == null || personDTO.getName() == null || personDTO.getId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        if (serviceEntity.idPersonValidate(personDTO.getId()))
        {
            return ResponseEntity.badRequest().build();
        }
        Date date = new Date();
        if (!(personDTO.getBirthdate().before(date))) {
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
