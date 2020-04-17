package himanshu.springframework.himanshupetclinic.bootstrap;

import himanshu.springframework.himanshupetclinic.model.Owner;
import himanshu.springframework.himanshupetclinic.model.Vet;
import himanshu.springframework.himanshupetclinic.services.OwnerService;
import himanshu.springframework.himanshupetclinic.services.VetService;
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
        owner1.setFirstName("Shivani");
        owner1.setLastName("Aggarwal");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ilika");
        owner2.setLastName("Chitranshi");

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
