package com.rcp.gitrepo.web.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(Include.NON_EMPTY)
public class Attribute {

    @Schema(description = "Id of the  git repo , exmaple 680653870")
    private String id;
    @Schema(description = "full_name of the git repo, example virtual/Xxx-zone-2")
    private String name;
    @Schema(description = "html_url of the git repo, example https://github.com/Xxx")
    private String url;
    @Schema(description = "optional description of the git repo")
    private String description;
    @Schema(description = "no of stars for the git repo")
    private String stars;
    @Schema(description = "language for the git repo")
    private String language;
    @Schema(description = "provide additional information")
    private Link links;

}