package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.Vet;
import himanshu.springframework.himanshupetclinic.services.VetService;

import java.util.Set;

public class VetServiceMapImpl extends AbstractMapService<Vet,Long> implements VetService {
    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Set<Vet> findByLastName(String lastName) {
        return null;
    }
}
