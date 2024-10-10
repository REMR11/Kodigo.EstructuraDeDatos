package kodigo.principiossolid.taskmanagement.repository;

import kodigo.principiossolid.taskmanagement.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TaskRepositoryImplement implements ITaskRepository{
    private List<Task> tasks;


    /**
     * @return
     */
    @Override
    public List<Task> GetTasks() {
        return List.of();
    }

    /**
     * @param task
     */
    @Override
    public void AddTask(Task task) {

    }
}
