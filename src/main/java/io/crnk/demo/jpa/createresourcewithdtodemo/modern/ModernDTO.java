package io.crnk.demo.jpa.createresourcewithdtodemo.modern;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonApiResource(type = "moderns")
public class ModernDTO {
    @JsonApiId
    Long id;

    String value;
}
