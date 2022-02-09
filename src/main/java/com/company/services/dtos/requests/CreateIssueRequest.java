package com.company.services.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateIssueRequest {

    private Integer id;

    private Long githubIssueId;

    private Long githubIssueNumber;

    private String title;

    private String body;

    private String url;

}
