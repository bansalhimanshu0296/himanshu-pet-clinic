package himanshu.springframework.himanshupetclinic.repositories;

import himanshu.springframework.himanshupetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
