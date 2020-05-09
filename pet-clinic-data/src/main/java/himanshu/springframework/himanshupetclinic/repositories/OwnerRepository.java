package himanshu.springframework.himanshupetclinic.repositories;

import himanshu.springframework.himanshupetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
    default Set<Owner> findByLastName(String lastName){
        Set<Owner> owners = new HashSet<>();
        this.findAll().forEach(owner ->{
            if(owner.getLastName().equalsIgnoreCase(lastName)) owners.add(owner);
        });
        return owners;
    }
}
