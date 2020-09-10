package se.lexicon.mattias.petclinic2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lexicon.mattias.petclinic2.entity.Owner;
import se.lexicon.mattias.petclinic2.entity.Pet;
import se.lexicon.mattias.petclinic2.entity.PetType;
import se.lexicon.mattias.petclinic2.repository.OwnerRepo;
import se.lexicon.mattias.petclinic2.repository.PetRepo;
import se.lexicon.mattias.petclinic2.repository.PetTypeRepo;

import java.time.LocalDate;

@SpringBootApplication
public class Petclinic2Application implements CommandLineRunner {

	PetTypeRepo typeRepo;
	OwnerRepo ownerRepo;
	PetRepo petRepo;

	@Autowired
	public Petclinic2Application(PetTypeRepo typeRepo, OwnerRepo ownerRepo, PetRepo petRepo) {
		this.typeRepo = typeRepo;
		this.ownerRepo = ownerRepo;
		this.petRepo = petRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Petclinic2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner = new Owner(null, "Mattias", "Andersson", "Hemma", "1234567890");
		ownerRepo.save(owner);

		PetType petType = new PetType(null, "Cat");
		typeRepo.save(petType);

		Pet pet = new Pet("null", "Misse", LocalDate.parse("2020-01-01"), petType, owner);
		petRepo.save(pet);

	}
}
