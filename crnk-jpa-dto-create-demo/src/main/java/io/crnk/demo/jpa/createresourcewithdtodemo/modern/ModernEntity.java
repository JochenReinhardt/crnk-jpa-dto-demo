package io.crnk.demo.jpa.createresourcewithdtodemo.modern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ModernEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String value;

    public ModernEntity(String value) {
        this.value = value;
    }

}
