package com.company.services.dtos.resources;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RepositoryResource {

    private Long id;

    private String organization;

    private String repository;

}
