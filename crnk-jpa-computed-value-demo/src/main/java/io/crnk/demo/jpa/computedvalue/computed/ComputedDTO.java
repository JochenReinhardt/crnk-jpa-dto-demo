package io.crnk.demo.jpa.computedvalue.computed;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonApiResource(type = "computeds")
public class ComputedDTO {
    @JsonApiId
    Long id;

    String value;

    String computedValue;
}
