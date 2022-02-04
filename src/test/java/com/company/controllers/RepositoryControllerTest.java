package com.company.controllers;

import com.company.models.Repository;
import com.company.services.RepositoryService;
import com.company.services.dtos.requests.CreateRepositoryRequest;
import com.company.services.dtos.resources.RepositoryResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RepositoryController.class)
@AutoConfigureMockMvc(addFilters = false)
public class RepositoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RepositoryService repositoryService;

    @Test
    public void it_should_list_repositories() throws Exception {
        Repository repository = Repository.builder()
                .organization("Emin0v").repository("githubproject").build();
        given(this.repositoryService.list()).willReturn(List.of(RepositoryResource.builder().organization(repository.getOrganization())
                .repository(repository.getRepository()).id(repository.getId()).build()));
        this.mockMvc.perform(get("/repositories")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].organization").value("Emin0v"))
                .andExpect(jsonPath("$[0].repository").value("githubproject"));

    }

    @Test
    public void it_should_create_repository() throws Exception {
        String organization = "Emin0v";
        String repository = "githubproject";

        CreateRepositoryRequest request = CreateRepositoryRequest.builder()
                .organization(organization).repository(repository)
                .build();

        doNothing().when(this.repositoryService).create(organization,repository);

        this.mockMvc.perform(post("/repositories").content(this.objectMapper.writeValueAsBytes(request)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isCreated());
    }
    



}