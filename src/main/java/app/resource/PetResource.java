package app.resource;

import app.model.Pet;
import app.model.PetStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import app.service.PetService;

import java.util.List;

@RestController
@RequestMapping(path = "/pet")
public class PetResource {

    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        petService.createPet(pet);
        return new ResponseEntity<>(pet, HttpStatus.CREATED);

    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Pet> findById(@PathVariable(name = "id") long id) {
        Pet pet  = petService.getById(id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @GetMapping(path = "/{petStatus}")
    public ResponseEntity<List<Pet>> getPetByStatus(@PathVariable(name = "petStatus") PetStatus petStatus) {
        List<Pet> petList  = petService.getByStatus(petStatus);
        return new ResponseEntity<>(petList, HttpStatus.OK);
    }

    @PostMapping(path ="/{newPet}")
    public ResponseEntity<String> updatePet(@PathVariable(name = "newPet") Pet pet) {
        petService.updateExistPet(pet);
        return new ResponseEntity<>("Pet " + pet.getName() + " updated.", HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePet(@PathVariable(name = "id") long id) {
        petService.deletePet(id);
        return new ResponseEntity<>("Pet " + petService.getById(id).getName() + " deleted.", HttpStatus.OK);
    }


}
