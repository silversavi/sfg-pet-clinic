package ee.slvr.sfgpetclinic.repositories;

import ee.slvr.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
