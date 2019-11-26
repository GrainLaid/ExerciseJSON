package net.test.service;

import net.test.DTO.CarDTO;
import net.test.DTO.PersonDTO;
import net.test.DTO.Statistics;
import net.test.entity.CarEntity;
import net.test.entity.ModelEntity;
import net.test.entity.PersonEntity;
import net.test.entity.VendorEntity;
import net.test.repositories.CarRepositories;
import net.test.repositories.ModelRepositories;
import net.test.repositories.PersonRepositories;
import net.test.repositories.VendorRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceEntity {
    private CarRepositories carRepositories;

    @Autowired
    public void setCarRepositories(CarRepositories carRepositories) {
        this.carRepositories = carRepositories;
    }

    private ModelRepositories modelRepositories;

    @Autowired
    public void setModelRepositories(ModelRepositories modelRepositories) {
        this.modelRepositories = modelRepositories;
    }

    private PersonRepositories personRepositories;

    @Autowired
    public void setPersonRepositories(PersonRepositories personRepositories) {
        this.personRepositories = personRepositories;
    }

    private VendorRepositories vendorRepositories;

    @Autowired
    public void setVendorRepositories(VendorRepositories vendorRepositories) {
        this.vendorRepositories = vendorRepositories;
    }
//перса добавить
    public void personSave(Long id, String name, Date birthdate) {
        personRepositories.save(new PersonEntity(id, name, birthdate));
    }

    //инфа о car and person
    public List carsPerson(Long idPerson) {

        CarEntity carEntity = new CarEntity();
        carEntity.setOwnerId(idPerson);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withIgnorePaths("model")
                .withIgnorePaths("horsepower");

        Example<CarEntity> example = Example.of(carEntity, matcher);
        List<CarDTO> carList = new ArrayList<>();

        List<CarEntity> result = carRepositories.findAll(example);

        for (int i = 0; i < result.size(); i++) {
            CarDTO carDTO = new CarDTO();
            CarEntity bufferCar = result.get(i);
            ModelEntity bufferModel = bufferCar.getModelEntity().get(0);
            VendorEntity vendorEntity = bufferModel.getVendorEntity().get(0);
            carDTO.setId(bufferCar.getId());
            carDTO.setModel(vendorEntity.getVendorName() + "-" + bufferModel.getModel());
            carDTO.setHorsepower(bufferCar.getHorsepower());
            carDTO.setOwnerId(bufferCar.getOwnerId());
            carList.add(carDTO);
        }
        return carList;
    }

    //Сохранение car
    public void carSave(Long id, String model, Integer horsepower, Long ownerId) {
        String vendor = model.split("-")[0];
        String modelName = model.substring(model.indexOf('-') + 1);
        VendorEntity vendorEntity = new VendorEntity();
        ModelEntity modelEntity = new ModelEntity();
        vendorEntity.setVendorName(vendor);
        List<VendorEntity> vendorList = new ArrayList<>();
        vendorList.add(vendorEntity);
        modelEntity.setModel(modelName);
        modelEntity.setVendorEntity(vendorList);
        List<ModelEntity> modelList = new ArrayList<>();
        modelList.add(modelEntity);
        carRepositories.save(new CarEntity(id, modelList, horsepower, ownerId));
    }

    //извлечение
    public PersonDTO retunrPerson(Long id) {
        PersonDTO personDTO = new PersonDTO();
        PersonEntity personEntity;
        try {
            personEntity = personRepositories.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
        personDTO.setId(personEntity.getId());
        personDTO.setBirthdate(personEntity.getBirthdate());
        personDTO.setName(personEntity.getName());

        return personDTO;
    }

    //стат
    public Statistics returnStatistics() {
        Statistics statistics = new Statistics();
        statistics.setPersonStat(personRepositories.count());
        statistics.setCarStat(carRepositories.count());
        statistics.setUniquevendorStat(vendorRepositories.countDistinctVendorNameBy());
        return statistics;
    }

    //удалить
    public void clearAll() {
        carRepositories.deleteAll();
        personRepositories.deleteAll();
        modelRepositories.deleteAll();
        vendorRepositories.deleteAll();
    }
}

