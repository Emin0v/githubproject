package com.company.repositories;

import com.company.models.Issue;
import com.company.models.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IssueRepository extends JpaRepository<Issue, Integer> {

    List<Issue> findAll();

    List<Issue> findByRepository(Repository repository);

    Optional<Issue> findByGithubIssueId(Long githubIssueId);

}
