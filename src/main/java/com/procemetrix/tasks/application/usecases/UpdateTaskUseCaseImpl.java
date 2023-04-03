package com.procemetrix.tasks.application.usecases;

import com.procemetrix.tasks.domain.models.Task;
import com.procemetrix.tasks.domain.ports.in.UpdateTaskUseCase;
import com.procemetrix.tasks.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return taskRepositoryPort.update(id, updateTask);
    }
}
