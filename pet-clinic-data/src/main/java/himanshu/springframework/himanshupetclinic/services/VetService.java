package himanshu.springframework.himanshupetclinic.services;

import himanshu.springframework.himanshupetclinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet,Long>{

    public Set<Vet> findByLastName(String lastName);

}
