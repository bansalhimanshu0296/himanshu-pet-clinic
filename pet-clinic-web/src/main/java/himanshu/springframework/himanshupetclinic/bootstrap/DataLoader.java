package himanshu.springframework.himanshupetclinic.bootstrap;

import himanshu.springframework.himanshupetclinic.model.*;
import himanshu.springframework.himanshupetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
        this.petService = petService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");

        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes......");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality savedRadiology =specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("Loaded Specialities......");

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
        owner2.setCity("Noida");
        owner2.setTelephone("2323212134");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(owner1);
        pet2.setName("Tom");
        pet2.setBirthDate(LocalDate.now());
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Loaded Owners......");
        Visit visit1 = new Visit();
        visit1.setDate(LocalDate.now());
        visit1.setPet(pet2);
        visit1.setDescription("Sneezy Kitty");

        visitService.save(visit1);
        System.out.println("Loaded Visits......");

        pet2.getVisits().add(visit1);
        petService.save(pet2);
        petService.save(pet1);

        Vet vet1 = new Vet();
        vet1.setFirstName("Himanshu");
        vet1.setLastName("Bansal");
        vet1.getSpecialities().add(savedSurgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Arjun");
        vet2.setLastName("Chauhan");
        vet2.getSpecialities().add(savedRadiology);

        vetService.save(vet2);

        System.out.println("Loaded Vets......");
    }
}
