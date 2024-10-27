package kodigo.principiossolid.taskmanagement;

import kodigo.principiossolid.taskmanagement.domain.Task;
import kodigo.principiossolid.taskmanagement.repository.TaskRepository;
import kodigo.principiossolid.taskmanagement.service.TaskManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task> taks = new ArrayList<>();
        TaskRepository taskRepos = new TaskRepository(taks);
        TaskManager taskManager = new TaskManager(taskRepos);


    }
}
