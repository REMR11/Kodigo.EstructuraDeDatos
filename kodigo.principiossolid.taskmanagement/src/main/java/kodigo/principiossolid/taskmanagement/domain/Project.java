package kodigo.principiossolid.taskmanagement.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Project {
    private String name;
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task pTask){
        tasks.add(pTask);
    }
}
