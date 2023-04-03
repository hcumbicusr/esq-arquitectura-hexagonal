package com.procemetrix.tasks.domain.ports.out;

import com.procemetrix.tasks.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
