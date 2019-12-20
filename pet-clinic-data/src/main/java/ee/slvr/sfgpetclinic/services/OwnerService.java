package ee.slvr.sfgpetclinic.services;

import ee.slvr.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastname);

}
