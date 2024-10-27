/***
 * Principio de inversion de dependencias
 * Se utiliza TaskRepositoryImplement como dependencia para la clase
 * TaskManager, en este caso  TaskManager depende de una abstraccion,
 * no directamente de una implementacion directa.
 */
package kodigo.principiossolid.taskmanagement.service;

import kodigo.principiossolid.taskmanagement.domain.Task;
import kodigo.principiossolid.taskmanagement.repository.TaskRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class TaskManager {
    private final TaskRepository taskRepository;

    public boolean addTask(Task pTask){
        return taskRepository.AddTask(pTask);
    }

    public List<Task> getAllTask(){
        return taskRepository.GetAllTasks();
    }

    public boolean updateTask(Task pTask){
        return taskRepository.updateTask(pTask);
    }

    public Optional<Task> searchTaskById(UUID pIdTask){
        return taskRepository.searchTaskById(pIdTask);
    }

    public Optional<Task> searchTaskByTitle(String pTitle){
        return taskRepository.searchTaskByTitle(pTitle);
    }

    public boolean deleteTask(UUID pIdTask){
        return taskRepository.deleteTask(pIdTask);
    }


}
