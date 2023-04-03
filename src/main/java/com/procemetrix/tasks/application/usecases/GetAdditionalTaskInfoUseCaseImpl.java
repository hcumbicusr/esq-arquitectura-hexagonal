package com.procemetrix.tasks.application.usecases;

import com.procemetrix.tasks.domain.models.AdditionalTaskInfo;
import com.procemetrix.tasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.procemetrix.tasks.domain.ports.out.ExternalServicePort;
import com.procemetrix.tasks.domain.ports.out.TaskRepositoryPort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {
    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
}
