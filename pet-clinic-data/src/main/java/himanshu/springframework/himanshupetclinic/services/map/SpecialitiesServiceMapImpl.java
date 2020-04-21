package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.Speciality;
import himanshu.springframework.himanshupetclinic.services.SpecialtiesService;
import org.springframework.stereotype.Service;

@Service
public class SpecialitiesServiceMapImpl extends AbstractMapService<Speciality,Long> implements SpecialtiesService {
}
