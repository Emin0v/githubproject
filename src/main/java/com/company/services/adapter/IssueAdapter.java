package com.company.services.adapter;

import com.company.models.Issue;
import com.company.services.dtos.requests.CreateIssueRequest;
import com.company.services.dtos.resources.IssueResource;

import java.util.List;

public interface IssueAdapter {

    IssueResource map(Issue issue);

    List<IssueResource> mapToIssueResource(List<Issue> issues);

    List<Issue> mapToIssueList(List<CreateIssueRequest> createIssueRequests);


}
