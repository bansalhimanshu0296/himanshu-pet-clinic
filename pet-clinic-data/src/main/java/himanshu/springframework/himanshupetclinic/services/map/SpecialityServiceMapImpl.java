package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.Speciality;
import himanshu.springframework.himanshupetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class SpecialityServiceMapImpl extends AbstractMapService<Speciality,Long> implements SpecialityService {
}
