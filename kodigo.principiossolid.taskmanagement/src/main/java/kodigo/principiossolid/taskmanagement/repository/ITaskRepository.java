package kodigo.principiossolid.taskmanagement.repository;

import kodigo.principiossolid.taskmanagement.domain.Task;

import java.util.List;

public interface ITaskRepository {
    List<Task>GetTasks();
    void AddTask(Task task);
}
