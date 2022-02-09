package com.company.services.adapter;

import com.company.models.Repository;
import com.company.services.dtos.requests.CreateRepositoryRequest;
import com.company.services.dtos.resources.RepositoryResource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RepositoryAdapter {

    Repository map(CreateRepositoryRequest request);

    Repository map(RepositoryResource resource);

    RepositoryResource map(Repository repository);

    List<RepositoryResource> map(List<Repository> repository);

    List<Repository> mapToRepository(List<RepositoryResource> repository);


}
