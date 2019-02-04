package io.crnk.demo.jpa.manytomany.left;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import io.crnk.core.resource.annotations.LookupIncludeBehavior;
import io.crnk.demo.jpa.manytomany.right.RightDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@JsonApiResource(type = "lefts")
public class LeftDTO {
    @JsonApiId
    private Long id;

    private String value;

    @JsonApiRelation(lookUp = LookupIncludeBehavior.AUTOMATICALLY_WHEN_NULL)
    private List<RightDTO> rights;
}
