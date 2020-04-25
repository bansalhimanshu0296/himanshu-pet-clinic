package himanshu.springframework.himanshupetclinic.services.springdatajpa;

import himanshu.springframework.himanshupetclinic.model.Vet;
import himanshu.springframework.himanshupetclinic.repositories.VetRepository;
import himanshu.springframework.himanshupetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaImpl implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findByLastName(String lastName) {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vet ->{
            if(vet.getLastName().equalsIgnoreCase(lastName)) vets.add(vet);
        });
        return vets;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
