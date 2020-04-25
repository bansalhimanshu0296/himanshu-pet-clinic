package himanshu.springframework.himanshupetclinic.repositories;

import himanshu.springframework.himanshupetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
