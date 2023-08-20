package com.rcp.gitrepo.web.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.rcp.gitrepo.TestFixtures;
import com.rcp.gitrepo.business.services.RepositoriesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = GitRepositoryController.class)
public class GitRepositoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RepositoriesService repositoriesService;


    @Test
    void shouldGetPopularRepositories() throws Exception {

        when(repositoriesService.getPublicRepositories(any())).thenReturn(TestFixtures.getGitRepositoriesResponse());

        RequestBuilder builder =MockMvcRequestBuilders.get(GitRepositoryApi.API_PATH)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON);;

        var response = mockMvc.perform(builder).andReturn();
        assertThat(response.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

    }

}
