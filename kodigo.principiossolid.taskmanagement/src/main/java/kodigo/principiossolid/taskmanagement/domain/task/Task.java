package kodigo.principiossolid.taskmanagement.domain.task;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@ToString
public class Task {
    private UUID idTask = UUID.randomUUID();
    private String title;
    private String description;
    private boolean isCompleted = false;
    private LocalDate date_Task;

    public Task(String title, String description, LocalDate dateTask) {
        this.title = title;
        this.description = description;
        this.date_Task = dateTask;
    }

    public void completeTask() {
        this.isCompleted = true;
    }

}