package kodigo.principiossolid.taskmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Task {
    private UUID idTask = UUID.randomUUID();
    private String title;
    private String description;
    private boolean isCompleted = false;
    private LocalDateTime date_Task;

    public void completeTask() {
        this.isCompleted = true;
    }

    /**
     * Método abstracto que puede ser implementado por las subclases
     * para proporcionar detalles específicos sobre la tarea.
     *
     * @return Detalles de la tarea.
     */
    public abstract String getTaskDetails();
}