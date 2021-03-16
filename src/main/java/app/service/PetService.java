package app.service;

import app.exceptions.PetNotFoundException;
import app.storage.PetRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import app.model.Pet;
import app.model.PetStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@Slf4j
public class PetService {

    @Autowired
    PetRepository petRepository;

    public void createPet(Pet pet) {
        log.info("createPet", pet);

        petRepository.save(pet);
    }

    public Pet getById(long id) {
        log.info("get pet by id");
    return petRepository.getOne(id);
    }

    public List<Pet> getByStatus(PetStatus petStatus) {
        log.info("get pet by status");
        return petRepository.findAllByPetStatus(petStatus);
    }

    public void updateExistPet (Pet pet) {
        log.info("update pet");
        petRepository.save(pet);
    }

    public void deletePet (long id) {
        log.info("delete pet");
        petRepository.deleteById(id);
    }

    public List<Pet> getPetList () {
        log.info("get pet list");
        return petRepository.findAll();
    }
}