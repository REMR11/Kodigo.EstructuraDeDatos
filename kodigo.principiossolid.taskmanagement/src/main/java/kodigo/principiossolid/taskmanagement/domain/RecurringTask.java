package kodigo.principiossolid.taskmanagement.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class RecurringTask extends Task {
    private ChronoUnit recurrenceUnit; // La unidad de tiempo para la recurrencia (días, semanas, etc.)
    private int recurrenceInterval; // El intervalo de recurrencia

    public RecurringTask(String title, String description, LocalDateTime date_Task, ChronoUnit recurrenceUnit, int recurrenceInterval) {
        super(UUID.randomUUID(), title, description, false, date_Task);
        this.recurrenceUnit = recurrenceUnit;
        this.recurrenceInterval = recurrenceInterval;
    }

    @Override
    public String getTaskDetails() {
        return String.format("Recurring Task: %s, Recurs every %d %s", getTitle(), recurrenceInterval, recurrenceUnit);
    }

    public LocalDateTime getNextOccurrence() {
        return getDate_Task().plus(recurrenceInterval, recurrenceUnit);
    }
}
