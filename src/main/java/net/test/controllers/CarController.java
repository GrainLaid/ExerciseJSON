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

    private CarRepositories carRepositories;
    @Autowired
    public void setCarRepositories(CarRepositories carRepositories) {
        this.carRepositories = carRepositories;
    }
    private PersonRepositories personRepositories;
    @Autowired
    public void setPersonRepositories(PersonRepositories personRepositories) {
        this.personRepositories = personRepositories;
    }
    @GetMapping("/person/{personId}/car")
    public List<CarEntity> getContactByPersonId(@PathVariable Long personId) {

        if(!personRepositories.existsById(personId)) {
            throw new NotFoundException("Person not found!");
        }

        return carRepositories.findByPersonId(personId);
    }

    @PostMapping("/car/{studentId}")
    public CarEntity addCar(@PathVariable Long personId,
                                    @Valid @RequestBody CarEntity carEntity) {
        return personRepositories.findById(personId)
                .map(personEntity -> {
                    carEntity.setPersonEntity(personEntity);
                    return carRepositories.save(carEntity);
                }).orElseThrow(() -> new NotFoundException("Person not found!"));
    }


    @DeleteMapping("/clear/{studentId}/{assignmentId}")
    public String deleteCar(@PathVariable Long personId,
                                   @PathVariable Long carId) {

        if(!personRepositories.existsById(personId)) {
            throw new NotFoundException("Person not found!");
        }

        return carRepositories.findById(carId)
                .map(carEntity -> {
                    carRepositories.delete(carEntity);
                    return "Deleted!";
                }).orElseThrow(() -> new NotFoundException("Person not found!"));
    }
}
