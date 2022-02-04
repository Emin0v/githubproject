package com.company.services.impl;

import com.company.exceptions.DuplicatedRepositoryException;
import com.company.models.Repository;
import com.company.repositories.RepositoryRepository;
import com.company.services.RepositoryService;
import com.company.services.adapter.RepositoryAdapter;
import com.company.services.dtos.resources.RepositoryResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RepositoryServiceImpl implements RepositoryService {

    private final RepositoryRepository repositoryRepository;
    private final RepositoryAdapter repositoryAdapter;

    @Transactional
    public void create(String organization, String repository) {

        Repository repo = Repository.builder().repository(repository)
                .organization(organization).build();

        this.repositoryRepository.save(repo);
    }

    public List<RepositoryResource> list() {
        return repositoryAdapter.map(repositoryRepository.findAll());
    }

    private void validate(String organization, String repository) {
        this.repositoryRepository.findByOrganizationAndRepository(organization, repository)
                .ifPresent((r) -> {
                    throw new DuplicatedRepositoryException(organization, repository);
                });
    }

    public RepositoryResource findById(Long repositoryId) {
        return repositoryAdapter.map(this.repositoryRepository.findById(repositoryId).orElseThrow(
                () -> new EntityNotFoundException(String.format("Repository: %d is not found", repositoryId))));

    }


}
