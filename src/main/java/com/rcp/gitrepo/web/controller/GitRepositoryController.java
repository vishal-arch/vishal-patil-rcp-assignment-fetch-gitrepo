package com.rcp.gitrepo.web.controller;


import static com.rcp.gitrepo.web.request.RepositoriesSortDirection.DESC;
import static com.rcp.gitrepo.web.request.RespositoriesSortBy.STARS;
import static org.springframework.http.HttpStatus.OK;

import com.rcp.gitrepo.business.services.RepositoriesService;
import com.rcp.gitrepo.web.request.RequestCriteria;
import com.rcp.gitrepo.web.response.GitRepositoriesResponse;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Validated
@RestController
public class GitRepositoryController implements GitRepositoryApi {

    private final String DEFAULT_RECORDS_TO_VIEW = "100";
    private RepositoriesService repositoriesService;

    /**
     * @see GitRepositoryApi#getPublicRepositories(String, String, String)
     */
    @Override
    public ResponseEntity<GitRepositoriesResponse> getPublicRepositories(String language, String dateFrom,
        String topRecords) {

        return new ResponseEntity<>(
            repositoriesService.getPublicRepositories(getRequestCriteria(language, dateFrom, topRecords)), OK);
    }

    private RequestCriteria getRequestCriteria(String language, String dateFrom,
        String topRecords) {

        return RequestCriteria.builder()
            .language(language)
            .dateFrom(StringUtils.isEmpty(dateFrom) ? LocalDate.now().toString() : dateFrom)//defaulting to today's date
            .topRecordsToView(StringUtils.isEmpty(topRecords) ? DEFAULT_RECORDS_TO_VIEW : topRecords)
            .sortBy(STARS) // defaulted by stars as we want repos based on popularity
            .sortDirection(DESC) //defaulted to descending as the most popular repos should be on top
            .build();

    }

}
