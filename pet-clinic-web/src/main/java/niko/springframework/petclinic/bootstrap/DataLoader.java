package niko.springframework.petclinic.bootstrap;

import niko.springframework.petclinic.model.Owner;
import niko.springframework.petclinic.model.Vet;
import niko.springframework.petclinic.services.OwnerService;
import niko.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;

  public DataLoader(OwnerService ownerService, VetService vetService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
  }

  @Override
  public void run(String... args) throws Exception {

    Owner owner1 = new Owner();
    owner1.setId(1L);
    owner1.setFirstName("James");
    owner1.setLastName("Hetfield");

    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setId(2L);
    owner2.setFirstName("Lars");
    owner2.setLastName("Ulrich");

    ownerService.save(owner2);

    System.out.println("Loaded Owners...");

    Vet vet1 = new Vet();
    vet1.setId(1L);
    vet1.setFirstName("Kirk");
    vet1.setLastName("Hammett");

    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setId(2L);
    vet2.setFirstName("Robert");
    vet2.setLastName("Trujillo");

    vetService.save(vet2);

    System.out.println("Loaded Vets...");

  }
}
