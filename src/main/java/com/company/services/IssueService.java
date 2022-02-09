package com.company.services;

import com.company.models.Issue;
import com.company.services.dtos.requests.CreateIssueRequest;
import com.company.services.dtos.resources.IssueResource;

import java.util.List;

public interface IssueService {

    void saveAll(List<CreateIssueRequest> issues);

    List<IssueResource> list(Long repositoryId);

    IssueResource findRandomIssue();
}
