package se.lexicon.mattias.petclinic2.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.mattias.petclinic2.entity.Visit;

public interface VisitRepo extends CrudRepository<Visit, String> {


}
