package kodigo.principiossolid.taskmanagement.service;

import kodigo.principiossolid.taskmanagement.domain.Project;
import kodigo.principiossolid.taskmanagement.domain.Task;
import kodigo.principiossolid.taskmanagement.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskManager {
    private List<Task> tasks;
    private List<Project> projects;
    private List<User> users;
}
