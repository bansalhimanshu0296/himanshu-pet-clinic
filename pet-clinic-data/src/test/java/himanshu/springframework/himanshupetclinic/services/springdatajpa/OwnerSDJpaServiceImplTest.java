package himanshu.springframework.himanshupetclinic.services.springdatajpa;

import himanshu.springframework.himanshupetclinic.model.Owner;
import himanshu.springframework.himanshupetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceImplTest {

    public static final String LAST_NAME = "Bansal";
    @Mock
    OwnerRepository ownerRepository;
    @InjectMocks
    OwnerSDJpaServiceImpl ownerSDJpaService;

    Set<Owner> owners;
    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        owners = new HashSet<>();
        owners.add(owner);
        Mockito.when(ownerRepository.findByLastName(any())).thenReturn(owners);
        Set<Owner> ownerSet = ownerSDJpaService.findByLastName(LAST_NAME);
        assertEquals(1,ownerSet.size());
        Mockito.verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        Mockito.when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> owners = ownerSDJpaService.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void save() {
        Mockito.when(ownerRepository.save(any())).thenReturn(owner);
        Owner savedOwner = ownerSDJpaService.save(owner);
        assertNotNull(savedOwner);
        Mockito.verify(ownerRepository).save(any());
    }

    @Test
    void findById() {

        Mockito.when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        assertNotNull(ownerSDJpaService.findById(1L));
    }

    @Test
    void findByIdNotFound() {
        Mockito.when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerSDJpaService.findById(1L);
        assertNull(owner);
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(owner);
        Mockito.verify(ownerRepository,Mockito.times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);
        Mockito.verify(ownerRepository).deleteById(anyLong());
    }
}