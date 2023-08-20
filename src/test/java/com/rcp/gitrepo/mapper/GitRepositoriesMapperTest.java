package com.rcp.gitrepo.mapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.rcp.gitrepo.TestFixtures;
import com.rcp.gitrepo.web.response.GitRepositoriesResponse;
import com.rcp.gitrepo.web.response.RepositoryType;
import org.junit.jupiter.api.Test;

public class GitRepositoriesMapperTest {


    @Test
    void shouldMapEndPointResponseToGitRepositoriesResponse() {

        var gitEnpointResponse = TestFixtures.createGitEnpointResponse();
        var mappedResponse = GitRepositoriesMapper.INSTANCE.mapToGitRepositoriesResponse(gitEnpointResponse);
        assertThat(mappedResponse).isNotNull();
        assertMappedDetails(mappedResponse);
    }

    private void assertMappedDetails(GitRepositoriesResponse mappedResponse) {

        //As we only set one repository in the api response we are just getting index 0
        var data = mappedResponse.getData().get(0);
        assertAll(() -> {
                assertThat(mappedResponse.getType()).isEqualTo(RepositoryType.POPULAR_GIT_REPO);
                assertThat(data.getAttributes().getId()).isEqualTo("Dummy-id");
                assertThat(data.getAttributes().getLanguage()).isEqualTo("Java");
                assertThat(data.getAttributes().getDescription()).isEqualTo("This is a dummy description");
                assertThat(data.getAttributes().getName()).isEqualTo("Dummy Repo");
                assertThat(data.getAttributes().getStars()).isEqualTo("100");
                assertThat(data.getAttributes().getUrl()).isEqualTo("http://dummy.com");
                assertThat(data.getAttributes().getLinks().getAvatarLink()).isEqualTo("http://dummy-avatar");
            }
        );

    }
}
