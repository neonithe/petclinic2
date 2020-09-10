package se.lexicon.mattias.petclinic2.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.mattias.petclinic2.entity.Owner;

public interface OwnerRepo extends CrudRepository<Owner, String> {



}
