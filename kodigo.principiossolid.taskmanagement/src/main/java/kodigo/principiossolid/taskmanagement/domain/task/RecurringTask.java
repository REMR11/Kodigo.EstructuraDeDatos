/**
 * Clase que representa una tarea recurrente que se repite en intervalos de tiempo específicos.
 *
 * Esta clase extiende la clase {@link Task} y añade propiedades para manejar la recurrencia
 * de la tarea, incluyendo la unidad de tiempo y el intervalo de recurrencia. Permite gestionar
 * tareas que deben realizarse repetidamente, facilitando la planificación y el seguimiento.
 *
 * Esta clase cumple con los siguientes principios SOLID:
 *
 * - **Principio de Responsabilidad Única (SRP)**: La clase tiene una única responsabilidad:
 *   representar una tarea recurrente. Cualquier cambio relacionado con la gestión de tareas
 *   recurrentes se puede realizar en esta clase sin afectar a otras partes del sistema.
 *
 * - **Principio de Abierto/Cerrado (OCP)**: La clase está abierta a la extensión (puede ser
 *   extendida por otras clases) pero cerrada a la modificación (no es necesario modificar la
 *   clase base {@link Task} para agregar nuevas funcionalidades relacionadas con la recurrencia).
 *
 * - **Principio de Sustitución de Liskov (LSP)**: La clase puede ser utilizada en lugar de su
 *   clase base {@link Task} sin alterar el comportamiento esperado del sistema. Cualquier
 *   instancia de {@link RecurringTask} puede ser tratada como una {@link Task}.
 *
 * - **Principio de Inversión de Dependencias (DIP)**: La clase puede ser utilizada en un contexto
 *   donde se dependa de la abstracción {@link Task}, permitiendo que el código que utiliza esta
 *   clase no dependa de la implementación concreta.
 */
package kodigo.principiossolid.taskmanagement.domain.task;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class RecurringTask extends Task {
    private ChronoUnit recurrenceUnit; // La unidad de tiempo para la recurrencia (días, semanas, etc.)
    private int recurrenceInterval; // El intervalo de recurrencia

    /**
     * Constructor para crear una nueva tarea recurrente.
     *
     * @param title           El título de la tarea.
     * @param description     La descripción de la tarea.
     * @param date_Task       La fecha de la tarea.
     * @param recurrenceUnit  La unidad de tiempo para la recurrencia (días, semanas, etc.).
     * @param recurrenceInterval El intervalo de recurrencia.
     */
    public RecurringTask(String title, String description, LocalDate date_Task, ChronoUnit recurrenceUnit, int recurrenceInterval) {
        super(title, description, date_Task);
        this.recurrenceUnit = recurrenceUnit;
        this.recurrenceInterval = recurrenceInterval;
    }

    /**
     * Obtiene los detalles de la tarea recurrente en formato de cadena.
     *
     * @return Una cadena que representa los detalles de la tarea recurrente.
     */
    public String getTaskDetails() {
        return String.format("Recurring Task: %s, Recurs every %d %s", getTitle(), recurrenceInterval, recurrenceUnit);
    }

    /**
     * Calcula la próxima fecha de la tarea recurrente.
     *
     * @return La próxima fecha de la tarea.
     */
    public LocalDate getNextOccurrence() {
        return getDate_Task().plus(recurrenceInterval, recurrenceUnit);
    }
}