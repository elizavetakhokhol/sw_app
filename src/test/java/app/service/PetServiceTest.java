package app.service;

import app.model.Category;
import app.model.Pet;
import app.storage.PetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PetServiceTest {

    @Autowired
    PetRepository petRepository;
    @Test
    void createPet() {

    }

    @Test
    void getById() {
    }

    @Test
    void getByStatus() {
    }

    @Test
    void updateExistPet() {
    }

    @Test
    void deletePet() {
    }
}