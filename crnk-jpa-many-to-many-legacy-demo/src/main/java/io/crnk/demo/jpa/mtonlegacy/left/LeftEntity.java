package io.crnk.demo.jpa.mtonlegacy.left;

import io.crnk.demo.jpa.mtonlegacy.right.RightEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LeftEntity {
    @Id
    private Long id;

    private String value;

    @ManyToMany()
    private Set<RightEntity> rights = new HashSet<>();

    public LeftEntity(long id, String value) {
        this.id = id;
        this.value = value;
    }

}
