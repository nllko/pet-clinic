package niko.springframework.petclinic.bootstrap;

import java.time.LocalDate;
import niko.springframework.petclinic.model.Owner;
import niko.springframework.petclinic.model.Pet;
import niko.springframework.petclinic.model.PetType;
import niko.springframework.petclinic.model.Vet;
import niko.springframework.petclinic.services.OwnerService;
import niko.springframework.petclinic.services.PetTypeService;
import niko.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;

  public DataLoader(OwnerService ownerService, VetService vetService,
      PetTypeService petTypeService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
  }

  @Override
  public void run(String... args) throws Exception {

    PetType dog = new PetType();
    dog.setName("Dog");
    PetType savedDogPetType = petTypeService.save(dog);

    PetType cat = new PetType();
    dog.setName("Cat");
    PetType savedCatPetType = petTypeService.save(cat);

    Owner owner1 = new Owner();
    owner1.setFirstName("James");
    owner1.setLastName("Hetfield");
    owner1.setAddress("123 Random");
    owner1.setCity("Not a city");
    owner1.setTelephone("82354238523");

    Pet jamesPet = new Pet();
    jamesPet.setPetType(savedDogPetType);
    jamesPet.setOwner(owner1);
    jamesPet.setBirthDate(LocalDate.now());
    jamesPet.setName("Doggo");
    owner1.getPets().add(jamesPet);

    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Lars");
    owner2.setLastName("Ulrich");
    owner1.setAddress("777 Bogdan Street");
    owner1.setCity("Zalupkina");
    owner1.setTelephone("5415641654");

    Pet larsPet = new Pet();
    larsPet.setPetType(savedCatPetType);
    larsPet.setOwner(owner2);
    larsPet.setBirthDate(LocalDate.now());
    larsPet.setName("Catie");
    owner2.getPets().add(larsPet);

    ownerService.save(owner2);

    System.out.println("Loaded Owners...");

    Vet vet1 = new Vet();
    vet1.setFirstName("Kirk");
    vet1.setLastName("Hammett");

    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Robert");
    vet2.setLastName("Trujillo");

    vetService.save(vet2);

    System.out.println("Loaded Vets...");

  }
}
