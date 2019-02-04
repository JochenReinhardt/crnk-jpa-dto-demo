package io.crnk.demo.jpa.repositorydecorator.traditional;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonApiResource(type = "traditionals")
public class TraditionalDTO {
    @JsonApiId
    Long id;

    String value;
}
