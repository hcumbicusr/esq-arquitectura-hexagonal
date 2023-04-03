package com.procemetrix.tasks.infrastructure.config;

import com.procemetrix.tasks.application.services.TaskService;
import com.procemetrix.tasks.application.usecases.*;
import com.procemetrix.tasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.procemetrix.tasks.domain.ports.out.ExternalServicePort;
import com.procemetrix.tasks.domain.ports.out.TaskRepositoryPort;
import com.procemetrix.tasks.infrastructure.adapters.ExternalServiceAdapter;
import com.procemetrix.tasks.infrastructure.repositories.JpaTaskRepository;
import com.procemetrix.tasks.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }


    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }
}
