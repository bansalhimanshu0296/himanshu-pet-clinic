package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.Owner;
import himanshu.springframework.himanshupetclinic.services.CrudService;

public class OwnerServiceMapImpl extends AbstractMapService<Owner,Long> implements CrudService<Owner,Long>{
    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }
}
