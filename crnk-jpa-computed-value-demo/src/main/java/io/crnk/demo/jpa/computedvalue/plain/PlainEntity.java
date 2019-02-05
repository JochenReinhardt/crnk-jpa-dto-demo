package io.crnk.demo.jpa.computedvalue.plain;

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
public class PlainEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String value;

    public PlainEntity(String value) {
        this.value = value;
    }

}
