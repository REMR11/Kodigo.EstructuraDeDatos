/**
 * Clase que representa una tarea con un nivel de prioridad asociado.
 *
 * Esta clase extiende la clase {@link Task} y añade un campo para la prioridad
 * de la tarea. Permite gestionar tareas que tienen diferentes niveles de
 * importancia, facilitando la organización y el enfoque en las tareas más
 * críticas.
 *
 * Esta clase cumple con los siguientes principios SOLID:
 *
 * - **Principio de Responsabilidad Única (SRP)**: La clase tiene una única
 *   responsabilidad: representar una tarea con un nivel de prioridad.
 *   Cualquier cambio relacionado con la gestión de prioridades se puede
 *   realizar en esta clase sin afectar a otras partes del sistema.
 *
 * - **Principio de Abierto/Cerrado (OCP)**: La clase está abierta a la
 *   extensión (puede ser extendida por otras clases) pero cerrada a la
 *   modificación (no es necesario modificar la clase base {@link Task} para
 *   agregar nuevas funcionalidades relacionadas con la prioridad).
 *
 * - **Principio de Sustitución de Liskov (LSP)**: La clase puede ser utilizada
 *   en lugar de su clase base {@link Task} sin alterar el comportamiento
 *   esperado del sistema. Cualquier instancia de {@link PriorityTask} puede
 *   ser tratada como una {@link Task}.
 *
 * - **Principio de Inversión de Dependencias (DIP)**: La clase puede ser
 *   utilizada en un contexto donde se dependa de la abstracción {@link Task},
 *   permitiendo que el código que utiliza esta clase no dependa de la
 *   implementación concreta.
 */
package kodigo.principiossolid.taskmanagement.domain.task;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class PriorityTask extends Task {
    private int priority; // Un valor que representa la prioridad de la tarea (1 = alta, 2 = media, 3 = baja)

    /**
     * Constructor para crear una nueva tarea de prioridad.
     *
     * @param title       El título de la tarea.
     * @param description La descripción de la tarea.
     * @param date_Task   La fecha de la tarea.
     * @param priority    El nivel de prioridad de la tarea (1 = alta, 2 = media, 3 = baja).
     */
    public PriorityTask(String title, String description, LocalDate date_Task, int priority) {
        super(title, description, date_Task);
        this.priority = priority;
    }

    /**
     * Obtiene los detalles de la tarea de prioridad en formato de cadena.
     *
     * @return Una cadena que representa los detalles de la tarea de prioridad.
     */
    public String getTaskDetails() {
        return String.format("Priority Task: %s, Priority Level: %d", getTitle(), priority);
    }

    /**
     * Verifica si la tarea tiene alta prioridad.
     *
     * @return true si la prioridad es alta (1), false en caso contrario.
     */
    public boolean isHighPriority() {
        return priority == 1;
    }
}