package io.crnk.demo.jpa.computedvalue.plain;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonApiResource(type = "plains")
public class PlainDTO {
    @JsonApiId
    Long id;

    String value;
}
