package com.company.services.impl;

import com.company.models.Issue;
import com.company.models.Repository;
import com.company.repositories.IssueRepository;
import com.company.services.IssueService;
import com.company.services.RepositoryService;
import com.company.services.adapter.IssueAdapter;
import com.company.services.adapter.RepositoryAdapter;
import com.company.services.dtos.requests.CreateIssueRequest;
import com.company.services.dtos.resources.IssueResource;
import com.company.services.dtos.resources.RepositoryResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {

    private final IssueRepository repository;

    private final RepositoryService repositoryService;

    private final IssueAdapter issueAdapter;
    private final RepositoryAdapter repositoryAdapter;

    @Override
    @Transactional
    public void saveAll(List<CreateIssueRequest> issues) {
        List<Issue> issueList = this.issueAdapter.mapToIssueList(issues);
        issueList.forEach(issue -> {
            if (this.repository.findByGithubIssueId(issue.getGithubIssueId()).isEmpty()){
                this.repository.save(issue);
            }
        });
    }

    @Override
    public List<IssueResource> list(Long repositoryId) {
        RepositoryResource resource = this.repositoryService.findById(repositoryId);
        Repository repository = this.repositoryAdapter.map(resource);
        List<Issue> issues = this.repository.findByRepository(repository);
        return this.issueAdapter.mapToIssueResource(issues);
    }

    @Override
    public IssueResource findRandomIssue() {
        this.repository.
    }
}
