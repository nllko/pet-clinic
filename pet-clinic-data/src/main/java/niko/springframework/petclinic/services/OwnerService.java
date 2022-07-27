package niko.springframework.petclinic.services;

import java.util.Set;
import niko.springframework.petclinic.model.Owner;

public interface OwnerService {

  Owner findByLastName(String lastName);

  Owner findById(Long id);

  Owner save(Owner owner);

  Set<Owner> findAll();
}
