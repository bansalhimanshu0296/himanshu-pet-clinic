package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.Pet;
import himanshu.springframework.himanshupetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class PetServiceMapImpl extends AbstractMapService<Pet,Long> implements PetService {

}
