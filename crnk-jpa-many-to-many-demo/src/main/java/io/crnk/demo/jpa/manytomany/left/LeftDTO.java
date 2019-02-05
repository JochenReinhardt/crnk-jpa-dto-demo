package io.crnk.demo.jpa.manytomany.left;

import io.crnk.core.resource.annotations.*;
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

    @JsonApiRelation(repositoryBehavior = RelationshipRepositoryBehavior.FORWARD_OWNER, lookUp = LookupIncludeBehavior.AUTOMATICALLY_WHEN_NULL, serialize = SerializeType.LAZY)
    private List<RightDTO> rights;
}
