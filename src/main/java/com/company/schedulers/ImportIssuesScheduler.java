package com.company.schedulers;

import com.company.managers.RepositoryManager;
import com.company.models.Repository;
import com.company.services.RepositoryService;
import com.company.services.adapter.RepositoryAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ImportIssuesScheduler {

    private final RepositoryService repositoryService;

    private final RepositoryAdapter repositoryAdapter;

    private final RepositoryManager repositoryManager;

    @Scheduled(fixedRateString = "${application.import-frequency}", initialDelay = 60000)
    public void importIssuesScheduler() {
        log.info("import scheduler started");
        List<Repository> repositories = this.repositoryAdapter.mapToRepository(this.repositoryService.list());
        repositories.forEach(repositoryManager::importIssues);
        log.info("import scheduler finished");
    }

}
