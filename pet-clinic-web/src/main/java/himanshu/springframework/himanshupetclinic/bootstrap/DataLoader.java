package himanshu.springframework.himanshupetclinic.bootstrap;

import himanshu.springframework.himanshupetclinic.model.Owner;
import himanshu.springframework.himanshupetclinic.model.Vet;
import himanshu.springframework.himanshupetclinic.services.OwnerService;
import himanshu.springframework.himanshupetclinic.services.VetService;
import himanshu.springframework.himanshupetclinic.services.map.OwnerServiceMapImpl;
import himanshu.springframework.himanshupetclinic.services.map.VetServiceMapImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMapImpl();
        this.vetService = new VetServiceMapImpl();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Shivani");
        owner1.setLastName("Aggarwal");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Ilika");
        owner1.setLastName("Chitranshi");

        ownerService.save(owner2);

        System.out.println("Loaded Owners......");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Himanshu");
        vet1.setLastName("Bansal");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Arjun");
        vet1.setLastName("Chauhan");

        vetService.save(vet2);

        System.out.println("Loaded Vets......");



    }
}
