package niko.springframework.petclinic.services;

import niko.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);

}
