package kodigo.principiossolid.taskmanagement.repository;

import kodigo.principiossolid.taskmanagement.domain.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ITaskRepository {
    boolean AddTask(Task pTask);
    Optional<Task> searchTaskById(UUID pIdTask);
    Optional<Task> searchTaskByTitle(String pTitle);
    List<Task>GetAllTasks();
    boolean updateTask(Task pTask);
    boolean deleteTask(UUID pIdTask);

}
