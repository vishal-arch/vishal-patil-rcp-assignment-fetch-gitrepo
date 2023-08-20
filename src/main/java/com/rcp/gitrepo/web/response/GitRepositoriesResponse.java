package com.rcp.gitrepo.web.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GitRepositoriesResponse {

    @Schema(description = "Represents the type of response/message")
    private RepositoryType type;
    @Schema(description = "List of repositories")
    private List<GitRespositoriesDetails> data;
}

