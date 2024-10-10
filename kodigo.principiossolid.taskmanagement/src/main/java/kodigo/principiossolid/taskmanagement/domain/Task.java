package kodigo.principiossolid.taskmanagement.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Task {
    private Integer idTask;
    private String title;
    private String description;
    private boolean statte_Task;
    private LocalDate date_Task;
}
