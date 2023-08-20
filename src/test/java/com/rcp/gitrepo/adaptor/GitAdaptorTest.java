package com.rcp.gitrepo.adaptor;

import static com.rcp.gitrepo.TestFixtures.createGitEnpointResponse;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.rcp.gitrepo.TestFixtures;
import com.rcp.gitrepo.configuration.ApplicationConfiguration;
import com.rcp.gitrepo.exception.CommunicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class GitAdaptorTest {

    private GitAdaptor gitAdaptor;
    private ApplicationConfiguration applicationConfiguration;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        applicationConfiguration = new ApplicationConfiguration();
        applicationConfiguration.setBaseUrl("http://dummy.com/");
        applicationConfiguration.setPath("v1/dummy");
        gitAdaptor = new GitAdaptor(restTemplate, applicationConfiguration);
    }

    @Test
    void shouldReturnSucessResponseWithResponseObject() {

        when(restTemplate.getForObject(anyString(), any())).thenReturn(createGitEnpointResponse());
        var response = gitAdaptor.getGetRepositoryDetails(TestFixtures.getRequestCriteria());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(createGitEnpointResponse());
    }

    @Test
    void shouldThrowCommunicationException() {

        when(restTemplate.getForObject(anyString(), any())).thenThrow(
            new CommunicationException("Error while calling"));

        assertThrows(CommunicationException.class,
            () -> gitAdaptor.getGetRepositoryDetails(TestFixtures.getRequestCriteria()));
    }

    @Test
    void shouldThrow4XXException() {

        when(restTemplate.getForObject(anyString(), any())).thenThrow(new HttpClientErrorException(BAD_REQUEST));

        assertThrows(HttpStatusCodeException.class,
            () -> gitAdaptor.getGetRepositoryDetails(TestFixtures.getRequestCriteria()));
    }
}
