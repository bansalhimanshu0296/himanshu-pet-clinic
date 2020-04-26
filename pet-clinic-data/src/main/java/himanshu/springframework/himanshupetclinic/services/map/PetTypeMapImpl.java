package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.PetType;
import himanshu.springframework.himanshupetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class PetTypeMapImpl extends AbstractMapService<PetType,Long> implements PetTypeService {
}
