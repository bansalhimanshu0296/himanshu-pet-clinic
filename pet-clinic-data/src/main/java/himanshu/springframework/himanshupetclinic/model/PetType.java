package himanshu.springframework.himanshupetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

    private String name;
}
