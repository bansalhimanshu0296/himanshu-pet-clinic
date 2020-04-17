package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.Owner;
import himanshu.springframework.himanshupetclinic.services.OwnerService;

import java.util.Set;

public class OwnerServiceMapImpl extends AbstractMapService<Owner,Long> implements OwnerService {
    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Set<Owner> findByLastName(String lastName) {
        return null;
    }
}
