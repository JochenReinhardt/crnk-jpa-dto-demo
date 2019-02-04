package io.crnk.demo.jpa.mtonlegacy.right;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonApiResource(type = "rights")
public class RightDTO {
    @JsonApiId
    Long id;

    String value;
}
