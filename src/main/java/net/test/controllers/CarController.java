package net.test.controllers;

import net.test.entity.CarEntity;
import net.test.exception.NotFoundException;
import net.test.repositories.CarRepositories;
import net.test.repositories.PersonRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarRepositories carRepositories;


    private PersonRepositories personRepositories;

    @Autowired
    public void setPersonRepositories(PersonRepositories personRepositories) {
        this.personRepositories = personRepositories;
    }

    @GetMapping("/person/{personId}/car")
    public List<CarEntity> getContactByPersonId(@PathVariable Long personId) {

        if (!personRepositories.existsById(personId)) {
            throw new NotFoundException("Person not found!");
        }

        return carRepositories.findByPersonEntityId(personId);
    }

    @PostMapping("/car/{personId}")
    public CarEntity addCar(@PathVariable Long personId,
                            @Valid @RequestBody CarEntity carEntity) {
        return personRepositories.findById(personId)
                .map(personEntity -> {
                    carEntity.setPersonEntity(personEntity);
                    return carRepositories.save(carEntity);
                }).orElseThrow(() -> new NotFoundException("Person not found!"));
    }

}
