package himanshu.springframework.himanshupetclinic.bootstrap;

import himanshu.springframework.himanshupetclinic.model.Owner;
import himanshu.springframework.himanshupetclinic.model.Pet;
import himanshu.springframework.himanshupetclinic.model.PetType;
import himanshu.springframework.himanshupetclinic.model.Vet;
import himanshu.springframework.himanshupetclinic.services.OwnerService;
import himanshu.springframework.himanshupetclinic.services.PetTypeService;
import himanshu.springframework.himanshupetclinic.services.VetService;
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
        dog.setName("dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");

        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes......");


        Owner owner1 = new Owner();
        owner1.setFirstName("Shivani");
        owner1.setLastName("Aggarwal");
        owner1.setAddress("B-15 Second Floor, Ardee City, Sector 52");
        owner1.setCity("Gurgaon");
        owner1.setTelephone("12121212");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogPetType);
        pet1.setOwner(owner1);
        pet1.setName("Bravo");
        pet1.setBirthDate(LocalDate.now());
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ilika");
        owner2.setLastName("Chitranshi");
        owner2.setAddress("F-706 Amrapali Princely Estate, Sector 76");
        owner1.setCity("Noida");
        owner1.setTelephone("2323212134");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(owner1);
        pet2.setName("Tom");
        pet2.setBirthDate(LocalDate.now());
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Loaded Owners......");




                Vet vet1 = new Vet();
        vet1.setFirstName("Himanshu");
        vet1.setLastName("Bansal");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Arjun");
        vet2.setLastName("Chauhan");

        vetService.save(vet2);

        System.out.println("Loaded Vets......");
    }
}
