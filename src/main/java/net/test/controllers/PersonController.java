package net.test.controllers;

import net.test.dto.PersonDto;
import net.test.entity.PersonEntity;
import net.test.exception.NotFoundException;
import net.test.repositories.PersonRepositories;
import net.test.util.DTO;
import net.test.valid.DateValid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private PersonRepositories personRepositories;

    @Autowired
    public void setPersonRepositories(PersonRepositories personRepositories) {
        this.personRepositories = personRepositories;
    }

    @GetMapping("/person")
    public List<PersonEntity> getAllPerson() {
        return personRepositories.findAll();
    }

    @GetMapping("/person/{id}")
    public PersonEntity getPersonByID(@PathVariable Long id) {
        Optional<PersonEntity> optionalPerson = personRepositories.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            throw new NotFoundException("Student not found with id " + id);
        }
    }

    @PostMapping("/person")
    public PersonEntity createPerson(@DTO(PersonDto.class)@Valid @RequestBody PersonEntity personEntity) throws ParseException {
        return personRepositories.save(personEntity);
    }

    @DeleteMapping("/clear/{id}")
    public String deletePerson(@PathVariable Long id) {
        return personRepositories.findById(id)
                .map(personEntity -> {
                    personRepositories.delete(personEntity);
                    return "Delete!";
                }).orElseThrow(() -> new NotFoundException("Student not found with id " + id));
    }
}
