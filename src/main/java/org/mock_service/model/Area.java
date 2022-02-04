package org.mock_service.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
public class Area {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy="area")
    private Set<Location> location;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        if (id == null) return false;
        Area area = (Area) o;
        return Objects.equals(id, area.id);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
