package himanshu.springframework.himanshupetclinic.repositories;

import himanshu.springframework.himanshupetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
