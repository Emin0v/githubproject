package com.company.controllers;

import com.company.models.Repository;
import com.company.services.RepositoryService;
import com.company.services.dtos.resources.RepositoryResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RepositoryController.class)
@AutoConfigureMockMvc(addFilters = false)
public class RepositoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

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

}