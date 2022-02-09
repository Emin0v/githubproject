package com.company.services.dtos.resources;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IssueResource {

    private Integer id;

    private Long githubIssueId;

    private Long githubIssueNumber;

    private String title;

    private String body;

    private String url;
}
