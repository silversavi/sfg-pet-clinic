package ee.slvr.sfgpetclinic.repositories;

import ee.slvr.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
