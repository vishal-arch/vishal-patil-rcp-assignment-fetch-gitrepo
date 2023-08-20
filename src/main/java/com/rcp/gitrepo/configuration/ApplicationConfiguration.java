package com.rcp.gitrepo.configuration;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "gitapi")
@Getter
@Setter
public class ApplicationConfiguration {

    @NonNull
    private String baseUrl;
    @NonNull
    private String path;
}
