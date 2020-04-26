package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.Vet;
import himanshu.springframework.himanshupetclinic.services.SpecialityService;
import himanshu.springframework.himanshupetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VetServiceMapImpl extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMapImpl(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Vet save(Vet object) {
        if (object != null) {
            if(object.getSpecialities()!=null){
                 if (object.getSpecialities().size()>0){
                     object.getSpecialities().forEach(speciality -> {
                         if(speciality.getId() == null){
                             speciality.setId(specialityService.save(speciality).getId());
                         }
                     });
                 }
            }
            return super.save(object);
        } else {
            return null;
        }
    }
}
