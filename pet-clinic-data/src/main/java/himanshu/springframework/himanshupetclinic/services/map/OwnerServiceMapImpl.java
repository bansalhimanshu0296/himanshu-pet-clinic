package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.Owner;
import himanshu.springframework.himanshupetclinic.services.OwnerService;
import himanshu.springframework.himanshupetclinic.services.PetService;
import himanshu.springframework.himanshupetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMapImpl extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMapImpl(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if(object.getPets()!=null){
                object.getPets().forEach(pet->{
                    if(pet.getPetType()!=null){
                        if(pet.getPetType().getId()==null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type is Required");
                    }
                    if(pet.getId()==null){
                        pet.setId(petService.save(pet).getId());
                    }
                });
            }
            return super.save(object);
        }
        else {
            return null;
        }
    }
}
