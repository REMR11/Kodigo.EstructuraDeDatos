package kodigo.principiossolid.taskmanagement.repository;

import kodigo.principiossolid.taskmanagement.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@AllArgsConstructor
public class TaskRepositoryImplement implements ITaskRepository{
    private List<Task> tasks = new ArrayList<>();


    /**
     * @param pTask
     * @return
     */
    @Override
    public boolean AddTask(Task pTask) {
        return tasks.add(pTask);
    }

    /**
     * @param pIdTask
     * @return
     */
    @Override
    public Optional<Task> searchTaskById(UUID pIdTask) {
        return tasks.stream()
                .filter(task -> task.getIdTask().equals(pIdTask))
                .findFirst();
    }

    /**
     * @param pTitle
     * @return
     */
    @Override
    public Optional<Task> searchTaskByTitle(String pTitle) {
        return tasks.stream()
                .filter(task -> task.getTitle().equalsIgnoreCase(pTitle))
                .findFirst();
    }

    /**
     * @return
     */
    @Override
    public List<Task> GetAllTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public boolean updateTask(Task pTask) {
        Optional<Task> taskOptional = searchTaskById(pTask.getIdTask());
        if (taskOptional.isPresent()) {
            Task existingTask = taskOptional.get();
            existingTask.setTitle(pTask.getTitle());
            existingTask.setDescription(pTask.getDescription());
            return true; // Retorna true si la actualización fue exitosa
        }
        return false; // Retorna false si no se encontró la tarea
    }

    /**
     * @param pIdTask
     * @return
     */
    @Override
    public boolean deleteTask(UUID pIdTask) {
        return tasks.removeIf(task -> task.getIdTask().equals(pIdTask));
    }
}
