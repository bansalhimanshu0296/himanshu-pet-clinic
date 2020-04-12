package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.Vet;
import himanshu.springframework.himanshupetclinic.services.CrudService;

public class VetServiceMapImpl extends AbstractMapService<Vet,Long> implements CrudService<Vet,Long> {
    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(),object);
    }
}
