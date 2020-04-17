package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.Pet;
import himanshu.springframework.himanshupetclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMapImpl extends AbstractMapService<Pet,Long> implements PetService {

}
