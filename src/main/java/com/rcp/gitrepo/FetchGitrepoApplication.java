package com.rcp.gitrepo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Repositories API", version = "1.0", description = "The Api has endpoint to fetch the most"
	+ " popular repositories from git."))

@SpringBootApplication
public class FetchGitrepoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FetchGitrepoApplication.class, args);
    }

}
