package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.Vet;
import himanshu.springframework.himanshupetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMapImpl extends AbstractMapService<Vet,Long> implements VetService {
    @Override
    public Set<Vet> findByLastName(String lastName) {
        return null;
    }
}
