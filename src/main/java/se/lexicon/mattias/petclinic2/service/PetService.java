package se.lexicon.mattias.petclinic2.service;

import se.lexicon.mattias.petclinic2.entity.Pet;

import java.util.List;

public interface PetService {

    //findPetByOwner
    //findPetBetweenDates

    //CRUD

    List<Pet> findAll();
    Pet findById(String petId);
    List<Pet> findByName(String petName);

    Pet save(Pet pet);
    Pet update(Pet pet);

    void delete(Pet pet);


}
