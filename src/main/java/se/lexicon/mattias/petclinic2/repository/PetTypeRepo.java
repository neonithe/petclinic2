package se.lexicon.mattias.petclinic2.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.mattias.petclinic2.entity.PetType;

public interface PetTypeRepo extends CrudRepository<PetType, Integer> {



}
