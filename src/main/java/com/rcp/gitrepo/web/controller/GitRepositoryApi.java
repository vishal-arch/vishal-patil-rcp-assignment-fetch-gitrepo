package com.rcp.gitrepo.web.controller;

import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.rcp.gitrepo.web.response.GitRepositoriesResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Popular Repositories", description = "Information about popular repositories")
@RequestMapping(GitRepositoryApi.API_PATH)
public interface GitRepositoryApi {

    String API_PATH = "/v1/api/repositories";

    @Operation(summary =
        "The endpoint returns popular repositories in Git, this information is fetch based on the values provided in query parameter"
            + "language, date_from, top_records.",
        responses = {
            @ApiResponse(responseCode = "200", description = "All stocks available.",
                content = {
                    @Content(
                        mediaType = APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = GitRepositoriesResponse.class),
                        examples = @ExampleObject(
                            name = "An example success response.",
                            // language=json
                            value = """
                                {
                                    "type": "POPULAR_GIT_REPO",
                                    "data": [
                                        {
                                            "attributes": {
                                                "id": "680547407",
                                                "name": "easychen/any2api",
                                                "url": "https://github.com/easychen/any2api",
                                                "description": "A framework( or a tool? ) that turns any website into an API",
                                                "stars": "35",
                                                "language": "JavaScript",
                                                "links": {
                                                    "avatarLink": "https://avatars.githubusercontent.com/u/1294760?v=4"
                                                }
                                            }
                                        },
                                        {
                                            "type": "GIT_REPO",
                                            "attributes": {
                                                "id": "680515130",
                                                "name": "iqbal-web/countdown-js",
                                                "url": "https://github.com/iqbal-web/countdown-js",
                                                "stars": "8",
                                                "language": "JavaScript",
                                                "links": {
                                                    "avatarLink": "https://avatars.githubusercontent.com/u/71224856?v=4"
                                                }
                                            }
                                        }]
                                    }
                                """
                        ))}
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data passed to query parameter.",
                content = {
                    @Content(
                        mediaType = APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = ProblemDetail.class),
                        examples = {
                            @ExampleObject(
                                name = "An example validation failure if top_records is not numeric.",
                                // language=json
                                value = """
                                    {
                                        "type": "about:blank",
                                        "title": "Bad Request",
                                        "status": 400,
                                        "detail": "getPublicRepositories.topRecords: top_records should only be numeric",
                                        "instance": "/v1/api/repositories"
                                    }
                                    """),
                            @ExampleObject(
                                name = "An example validation failure if date_from is not a valid date.",
                                // language=json
                                value = """
                                    {
                                          "type": "about:blank",
                                          "title": "Bad Request",
                                          "status": 400,
                                          "detail": "getPublicRepositories.dateFrom: date_from should be in 'YYYY-MM-DD'",
                                          "instance": "/v1/api/repositories"
                                      }
                                     """)
                        }
                    )
                }),
            @ApiResponse(responseCode = "500", description = "Communication exception while calling Github endpoint",
                content = {
                    @Content(
                        mediaType = APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = ProblemDetail.class),
                        examples = @ExampleObject(
                            name = "Communication exception while calling Github endpoint.",
                            // language=json
                            value = """
                                {
                                     "type": "about:blank",
                                     "title": "Internal Server Error",
                                     "status": 500,
                                     "detail": "Error while calling Git Repository, System exception",
                                     "instance": "/v1/api/repositories"
                                 }
                                """)
                    )
                })
        })
    @GetMapping
    default ResponseEntity<GitRepositoriesResponse> getPublicRepositories(
        @Parameter(name = "language",
            in = ParameterIn.QUERY,
            description = "optional query parameter to filter repositories based on language, example JavaScript or Java")
        @RequestParam(required = false) String language,

        @Parameter(name = "date_from",
            in = ParameterIn.QUERY,
            description =
                "optional query parameter to fetch repositories after the date passed, the format of the date is 'YYYY-MM-DD'"
                    + "if date_from is not passed the value of today's date will defaulted example 2023-01-01")
        @RequestParam(name = "date_from", required = false)
        @Pattern(regexp = "\\d{4}-[01]\\d-[0-3]\\d", message = "date_from should be in 'YYYY-MM-DD'") String dateFrom,

        @Parameter(name = "top_records",
            in = ParameterIn.QUERY,
            description = "optional query parameter to fetch no of repositories to be fetched, to fetch Top 10/50/100 repos please pass those values")
        @RequestParam(name = "top_records", required = false)
        @Positive(message = "top_records should only be numeric") String topRecords
    ) {

        return new ResponseEntity<>(NOT_IMPLEMENTED);

    }


}
