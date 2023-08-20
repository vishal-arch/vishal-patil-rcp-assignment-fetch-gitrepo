package com.rcp.gitrepo.business.services;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

import com.rcp.gitrepo.TestFixtures;
import com.rcp.gitrepo.adaptor.GitAdaptor;
import com.rcp.gitrepo.exception.CommunicationException;
import com.rcp.gitrepo.mapper.GitRepositoriesMapper;
import com.rcp.gitrepo.web.response.GitRepositoriesResponse;
import com.rcp.gitrepo.web.response.RepositoryType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class RepositoriesServiceTest {

    private RepositoriesService repositoriesService;

    @Mock
    private GitAdaptor gitAdaptor;
    @Mock
    private GitRepositoriesMapper mapper;

    @BeforeEach
    public void setUp() {
        repositoriesService = new RepositoriesService(gitAdaptor);
    }

    @Test
    void shouldFetchRepositories() {

        when(gitAdaptor.getGetRepositoryDetails(any())).thenReturn(
            new ResponseEntity<>(TestFixtures.createGitEnpointResponse(), OK));

        var gitResponse = repositoriesService.getPublicRepositories(TestFixtures.getRequestCriteria());
        assertThat(gitResponse).isNotNull();
        assertResponseDetails(gitResponse);
    }

    @Test
    void shouldNotInteractWithMapperWhenExceptionIsThrown() {

        when(gitAdaptor.getGetRepositoryDetails(any())).thenThrow(new CommunicationException(""));

        assertThrows(CommunicationException.class,
            () -> repositoriesService.getPublicRepositories(TestFixtures.getRequestCriteria()));
        verifyNoInteractions(mapper);

    }

    private void assertResponseDetails(GitRepositoriesResponse mappedResponse) {

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
