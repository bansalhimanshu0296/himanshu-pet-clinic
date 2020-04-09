package himanshu.springframework.himanshupetclinic.services;

import himanshu.springframework.himanshupetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    public Pet findById(Long id);

    public Pet save(Pet pet);

    public Set<Pet> findAll();
}
