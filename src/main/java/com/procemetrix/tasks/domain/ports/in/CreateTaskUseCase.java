package com.procemetrix.tasks.domain.ports.in;

import com.procemetrix.tasks.domain.models.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
