package io.crnk.demo.jpa.manytomany.right;

import io.crnk.demo.jpa.manytomany.left.LeftEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RightEntity {
    @Id
    private Long id;

    private String value;

    @ManyToMany(mappedBy = "rights")
    private Set<LeftEntity> lefts = new HashSet<>();

    public RightEntity(long id, String value) {
        this.id = id;
        this.value = value;
    }
}
