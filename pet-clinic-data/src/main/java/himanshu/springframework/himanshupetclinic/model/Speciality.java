package himanshu.springframework.himanshupetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity {

    private String description;

    @Builder
    public Speciality(Long id, String description) {
        super(id);
        this.description = description;
    }
}
