package net.test.controllers;

import net.test.DTO.PersonDTO;
import net.test.DTO.PersonWithCars;
import net.test.DTO.Statistics;
import net.test.service.ServiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class StatisticController {

    private final ServiceEntity serviceEntity;

    @Autowired
    public StatisticController(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    @RequestMapping(value = "/personwithcars", method = RequestMethod.GET)
    public @ResponseBody
    Object json(@RequestParam final Long personid) {
        PersonDTO personDTO = serviceEntity.retunrPerson(personid);

        if (personDTO == null) {
            return ResponseEntity.notFound().build();
        }

        List list = serviceEntity.carsPerson(personid);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        PersonWithCars personWithCars = new PersonWithCars();
        personWithCars.setId(personDTO.getId());
        personWithCars.setBirthdate(dateFormat.format(personDTO.getBirthdate()));
        personWithCars.setName(personDTO.getName());
        personWithCars.setCars(list);

        return personWithCars;
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public @ResponseBody
    Object json() {
        Statistics statistics = serviceEntity.returnStatistics();
        return statistics;
    }
}