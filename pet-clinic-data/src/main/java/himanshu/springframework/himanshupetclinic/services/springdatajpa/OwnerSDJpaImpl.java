package himanshu.springframework.himanshupetclinic.services.springdatajpa;

import himanshu.springframework.himanshupetclinic.model.Owner;
import himanshu.springframework.himanshupetclinic.repositories.OwnerRepository;
import himanshu.springframework.himanshupetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSDJpaImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findByLastName(String lastName) {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owner ->{
            if(owner.getLastName().equalsIgnoreCase(lastName)) owners.add(owner);
        });
        return owners;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners =new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
