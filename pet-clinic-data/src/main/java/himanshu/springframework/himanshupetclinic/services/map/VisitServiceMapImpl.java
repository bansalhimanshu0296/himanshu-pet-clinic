package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.Visit;
import himanshu.springframework.himanshupetclinic.services.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceMapImpl extends AbstractMapService<Visit,Long> implements VisitService {
    @Override
    public Visit save(Visit object) {
        if(object.getPet() == null || object.getPet().getId() == null || object.getPet().getOwner() == null ||
        object.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(object);
    }
}
