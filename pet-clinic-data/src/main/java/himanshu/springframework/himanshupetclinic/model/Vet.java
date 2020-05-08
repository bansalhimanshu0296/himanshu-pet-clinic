package himanshu.springframework.himanshupetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_speciality",
            joinColumns = @JoinColumn(name = "vet_id"),
    inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities;

    public Vet() {
        specialities = new HashSet<>();
    }

    @Builder
    public Vet(Long id, String firstName, String lastName, Set<Speciality> specialities) {
        super(id, firstName, lastName);
        if(specialities!=null)
            this.specialities = specialities;
        else
            this.specialities=new HashSet<>();
    }
}
