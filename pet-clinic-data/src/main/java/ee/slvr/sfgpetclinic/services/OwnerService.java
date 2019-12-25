package ee.slvr.sfgpetclinic.services;

import ee.slvr.sfgpetclinic.model.Owner;
import ee.slvr.sfgpetclinic.model.Person;

public interface OwnerService<O extends Person, L extends Number> extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
