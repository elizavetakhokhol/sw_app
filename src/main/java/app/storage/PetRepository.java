package app.storage;

import app.model.Category;
import app.model.Pet;
import app.model.PetStatus;
import app.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findAllByPetStatus(PetStatus petstatus);
}
