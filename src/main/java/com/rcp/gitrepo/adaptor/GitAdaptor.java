package com.rcp.gitrepo.adaptor;

import com.rcp.gitrepo.adaptor.model.GitRespositoriesEndpointResponse;
import com.rcp.gitrepo.configuration.ApplicationConfiguration;
import com.rcp.gitrepo.exception.CommunicationException;
import com.rcp.gitrepo.web.request.RequestCriteria;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Slf4j
@AllArgsConstructor
public class GitAdaptor {

    private final RestTemplate restTemplate;
    private final ApplicationConfiguration applicationConfiguration;
    private final String QUERY_PARAM_CREATED_DATE_PREFIX = "created:>";
    private final String QUERY_PARAM_LANGUAGE_CONDITION = "+language:";

    /**
     * The method make a Rest call to Git hub api to fetch all the popular repositories.
     *
     * @param requestCriteria
     * @return RespoonseEntity with Serialized response from the Git api {@link GitRespositoriesEndpointResponse}
     */
    public ResponseEntity<GitRespositoriesEndpointResponse> getGetRepositoryDetails(RequestCriteria requestCriteria) {

        try {
            var url = buildUrl(requestCriteria);
            log.info("fetching git repositories with url {}", url);
            var response = restTemplate.getForObject(url, GitRespositoriesEndpointResponse.class);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (HttpStatusCodeException exception) {
            log.error("Failed to fetch git repositories with exception", exception);
            throw exception;

        } catch (RestClientException clientException) {
            log.error("Error while fetching Git Repositories, with exception message: {}",
                clientException.getMessage());
            throw new CommunicationException("Error while calling Git Repository, System exception");
        }

    }

    private String buildUrl(RequestCriteria requestCriteria) {

        return UriComponentsBuilder.fromUriString(applicationConfiguration.getBaseUrl())
            .path(applicationConfiguration.getPath())
            .queryParam("q", getQueryCondition(requestCriteria))
            .queryParam("sort", requestCriteria.getSortBy())
            .queryParam("order", requestCriteria.getSortDirection())
            .queryParam("per_page", requestCriteria.getTopRecordsToView())
            .build(false)
            .toUriString();
    }

    private String getQueryCondition(RequestCriteria requestCriteria) {

        String query = QUERY_PARAM_CREATED_DATE_PREFIX + requestCriteria.getDateFrom();
        if (!StringUtils.isEmpty(requestCriteria.getLanguage())) {
            query += QUERY_PARAM_LANGUAGE_CONDITION + requestCriteria.getLanguage();
        }
        return query;
    }

}
