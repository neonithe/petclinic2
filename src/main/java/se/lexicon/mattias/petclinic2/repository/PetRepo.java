package se.lexicon.mattias.petclinic2.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.mattias.petclinic2.entity.Pet;

import java.util.List;

public interface PetRepo extends CrudRepository<Pet, String> {

    List<Pet> findAll();

    List<Pet> findAllByNameContainsIgnoreCase(String petName);

}
