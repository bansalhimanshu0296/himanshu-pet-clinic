package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.Pet;
import himanshu.springframework.himanshupetclinic.services.PetService;

public class PetServiceMapImpl extends AbstractMapService<Pet,Long> implements PetService {

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }
}
