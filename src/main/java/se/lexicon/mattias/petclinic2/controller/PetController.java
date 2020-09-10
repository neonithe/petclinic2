package se.lexicon.mattias.petclinic2.controller;

import org.springframework.http.ResponseEntity;
import se.lexicon.mattias.petclinic2.entity.Pet;

public interface PetController {

    ResponseEntity<Pet> findById(String petId);

    ResponseEntity<?> find(final String type, final String value);

    ResponseEntity<Pet> save(Pet pet);

    ResponseEntity<Pet> update(String id, Pet updated);




}
