package himanshu.springframework.himanshupetclinic.services;

import himanshu.springframework.himanshupetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    public Set<Vet> findByLastName(String lastName);

    public Vet findById(Long id);

    public Vet save(Vet vet);

    public Set<Vet> findAll();
}
