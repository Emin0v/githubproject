package com.company.services;

import com.company.models.Repository;
import com.company.services.dtos.resources.RepositoryResource;

import java.util.List;

public interface RepositoryService {

    void create(String organization, String repository);

    List<RepositoryResource> list();

    RepositoryResource findById(Long repositoryId);
}
