package ee.slvr.sfgpetclinic.bootstrap;

import ee.slvr.sfgpetclinic.model.Owner;
import ee.slvr.sfgpetclinic.model.Pet;
import ee.slvr.sfgpetclinic.model.PetType;
import ee.slvr.sfgpetclinic.model.Vet;
import ee.slvr.sfgpetclinic.services.OwnerService;
import ee.slvr.sfgpetclinic.services.PetTypeService;
import ee.slvr.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
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
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Micaeal");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Baker st");
        owner1.setCity("Miami");
        owner1.setTelephone("123123235234");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Russell");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Fromsherk");
        owner2.setAddress("123 Baker st");
        owner2.setCity("Miami");
        owner2.setTelephone("143242321123");

        Pet fionasCat = new Pet();
        fionasCat.setName("Curry");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Blulu");
        vet2.setLastName("West");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
