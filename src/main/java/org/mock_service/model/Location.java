package org.mock_service.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Index;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(indexes = { @Index(columnList = "name") })
public class Location {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @ManyToOne
    private Area area;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        if (id == null) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
