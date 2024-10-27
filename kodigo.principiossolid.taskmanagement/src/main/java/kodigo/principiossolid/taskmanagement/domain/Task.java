package kodigo.principiossolid.taskmanagement.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Task {
    private UUID idTask = UUID.randomUUID();
    private String title;
    private String description;
    private boolean isCompleted = false;
    private LocalDate date_Task;

    public void completeTask(){
        this.isCompleted = true;
    }
}
