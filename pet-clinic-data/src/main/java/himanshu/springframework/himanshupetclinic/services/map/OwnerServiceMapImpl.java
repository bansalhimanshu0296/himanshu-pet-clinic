package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.Owner;
import himanshu.springframework.himanshupetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMapImpl extends AbstractMapService<Owner,Long> implements OwnerService {
    @Override
    public Set<Owner> findByLastName(String lastName) {
        return null;
    }
}
