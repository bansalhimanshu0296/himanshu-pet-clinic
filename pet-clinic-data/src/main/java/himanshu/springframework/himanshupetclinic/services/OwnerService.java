package himanshu.springframework.himanshupetclinic.services;

import himanshu.springframework.himanshupetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    public Set<Owner> findByLastName(String lastName);

    public Owner findById(Long id);

    public Owner save(Owner owner);

    public Set<Owner> findAll();
}
