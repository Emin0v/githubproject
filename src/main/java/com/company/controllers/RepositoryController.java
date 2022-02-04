package com.company.controllers;

import com.company.services.dtos.requests.CreateRepositoryRequest;
import com.company.services.dtos.resources.RepositoryResource;
import com.company.services.RepositoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repositories")
public class RepositoryController {

    private final RepositoryService repositoryService;

    public RepositoryController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateRepositoryRequest request) {
        this.repositoryService.create(request.getOrganization(), request.getRepository());
    }

    @GetMapping
    public ResponseEntity<List<RepositoryResource>> list() {
        return ResponseEntity.ok(repositoryService.list());
    }

}
