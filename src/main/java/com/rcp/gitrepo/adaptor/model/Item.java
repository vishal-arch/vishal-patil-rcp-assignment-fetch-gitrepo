package com.rcp.gitrepo.adaptor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String id;
    @JsonProperty("full_name")
    private String fullName;
    private String description;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("stargazers_count")
    private String noOfStars;
    private String language;
    private Owner owner;

}