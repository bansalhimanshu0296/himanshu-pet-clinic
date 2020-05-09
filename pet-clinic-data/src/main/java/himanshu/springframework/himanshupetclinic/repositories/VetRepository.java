package himanshu.springframework.himanshupetclinic.repositories;

import himanshu.springframework.himanshupetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Set;

public interface VetRepository extends CrudRepository<Vet,Long> {
    default Set<Vet> findByLastName(String lastName){
        Set<Vet> vets = new HashSet<>();
        this.findAll().forEach(vet ->{
            if(vet.getLastName().equalsIgnoreCase(lastName)) vets.add(vet);
        });
        return vets;
    }
}
