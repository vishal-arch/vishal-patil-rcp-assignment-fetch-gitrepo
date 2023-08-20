package com.rcp.gitrepo.business.services;

import com.rcp.gitrepo.adaptor.GitAdaptor;
import com.rcp.gitrepo.mapper.GitRepositoriesMapper;
import com.rcp.gitrepo.web.request.RequestCriteria;
import com.rcp.gitrepo.web.response.GitRepositoriesResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class RepositoriesService {

    private GitAdaptor gitAdaptor;

    /**
     * The method returns the list of repositories based on filter criteria provided.
     *
     * @param requestCriteria object that contains the filter criteria {@link RequestCriteria}
     * @return List of Git respositories with details as {@link GitRepositoriesResponse}
     */
    public GitRepositoriesResponse getPublicRepositories(RequestCriteria requestCriteria) {

        log.info("fetching popular repositories for requestCriteria {}", requestCriteria);
        var repositories = gitAdaptor.getGetRepositoryDetails(requestCriteria);
        return GitRepositoriesMapper.INSTANCE.mapToGitRepositoriesResponse(repositories.getBody());
    }


}
