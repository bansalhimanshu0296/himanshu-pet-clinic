package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.PetType;
import himanshu.springframework.himanshupetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapImpl extends AbstractMapService<PetType,Long> implements PetTypeService {
}
