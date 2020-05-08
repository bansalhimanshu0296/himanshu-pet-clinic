package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapImplTest {

    OwnerServiceMapImpl ownerServiceMap;

    final Long ownerId = 1L;
    final String lastName="Bansal";
    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMapImpl(new PetServiceMapImpl(),new PetTypeServiceMapImpl());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void save() {
        Owner owner2 =Owner.builder().id(2L).build();
        Owner savedOwner=ownerServiceMap.save(owner2);
        assertEquals(owner2,savedOwner);
    }

    @Test
    void saveExistingId() {
        Long id = 1L;
        Owner owner3 =Owner.builder().id(id).build();
        assertThrows(RuntimeException.class,()-> {ownerServiceMap.save(owner3);});

    }

    @Test
    void saveNoId() {
        Owner savedOwner=ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Set<Owner> ownerSet = ownerServiceMap.findByLastName(lastName);
        assertNotNull(ownerSet);
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findByLastNameNotFound() {
        Set<Owner> ownerSet = ownerServiceMap.findByLastName("FOO");
        assertNull(ownerSet);
    }
}