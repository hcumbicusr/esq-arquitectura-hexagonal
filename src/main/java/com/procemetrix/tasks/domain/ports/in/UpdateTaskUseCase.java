package com.procemetrix.tasks.domain.ports.in;

import com.procemetrix.tasks.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task updateTask);
}
