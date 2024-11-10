package kodigo.principiossolid.taskmanagement.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class PriorityTask extends Task {
    private int priority; // Un valor que representa la prioridad de la tarea (1 = alta, 2 = media, 3 = baja)

    public PriorityTask(String title, String description, LocalDateTime date_Task, int priority) {
        super(UUID.randomUUID(), title, description, false, date_Task);
        this.priority = priority;
    }

    @Override
    public String getTaskDetails() {
        return String.format("Priority Task: %s, Priority Level: %d", getTitle(), priority);
    }

    public boolean isHighPriority() {
        return priority == 1;
    }
}
