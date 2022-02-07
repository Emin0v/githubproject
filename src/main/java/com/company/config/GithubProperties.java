package com.company.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "github")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GithubProperties {

    private String apiUrl;

    private String token;

}
