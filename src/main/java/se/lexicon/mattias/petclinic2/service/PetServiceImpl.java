package se.lexicon.mattias.petclinic2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.mattias.petclinic2.entity.Owner;
import se.lexicon.mattias.petclinic2.entity.Pet;
import se.lexicon.mattias.petclinic2.entity.PetType;
import se.lexicon.mattias.petclinic2.repository.OwnerRepo;
import se.lexicon.mattias.petclinic2.repository.PetRepo;
import se.lexicon.mattias.petclinic2.repository.PetTypeRepo;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class PetServiceImpl implements PetService{

    PetRepo petRepo;
    PetTypeRepo petTypeRepo;
    OwnerRepo ownerRepo;

    @Autowired
    public PetServiceImpl(PetRepo petRepo, PetTypeRepo petTypeRepo, OwnerRepo ownerRepo) {
        this.petRepo = petRepo;
        this.petTypeRepo = petTypeRepo;
        this.ownerRepo = ownerRepo;
    }




    @Override
    public List<Pet> findAll() {

        List<Pet> foundItems = petRepo.findAll();

        if ( foundItems.isEmpty() )
            throw new RuntimeException("Could not find any pets");

        return foundItems;
    }

    @Override
    public Pet findById(String petId) {

        return petRepo.findById(petId).orElseThrow(() -> new RuntimeException("Could not find anyone with this ID: "+petId)) ;
    }

    @Override
    public List<Pet> findByName(String petName) {

        List<Pet> foundItems = petRepo.findAllByNameContainsIgnoreCase(petName);

        if ( foundItems.isEmpty() ) throw new RuntimeException("Could not find any pet with name: "+petName);

        return foundItems;
    }

    @Override
    @Transactional
    public Pet save(Pet pet) {

        if ( pet.getPetId() != "" && pet.getPetId() != null ) throw new IllegalArgumentException("Could Not create a pet Where ID i specified");
/**
        Owner owner = null;
        PetType petType = null;
**/

        Pet toSave = new Pet(
                pet.getName(),
                pet.getBirthDate() == null ? LocalDate.now() : pet.getBirthDate(),
                pet.getPetType(),
                pet.getOwner()
        );

        return petRepo.save(toSave);
    }

    @Override
    public Pet update(Pet pet) {
        return null;
    }

    @Override
    public void delete(Pet pet) {

        petRepo.delete(pet);

    }
}
