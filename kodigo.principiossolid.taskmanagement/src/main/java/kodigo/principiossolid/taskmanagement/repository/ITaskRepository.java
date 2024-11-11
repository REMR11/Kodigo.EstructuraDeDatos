/**
 * Interfaz que define las operaciones para la gestión de tareas.
 *
 * Esta interfaz cumple con el siguiente principio SOLID:
 *
 * - **Principio de Responsabilidad Única (SRP)**: Cada método de esta interfaz
 *   se encarga de una única responsabilidad relacionada con la gestión de proyectos,
 *   como guardar, buscar, actualizar y eliminar proyectos.
 *
 * - **Principio Abierto/Cerrado (OCP)**: Esta interfaz está diseñada para ser
 *   extendida por otras clases sin necesidad de modificar su código.
 *   Las nuevas implementaciones pueden agregar funcionalidades adicionales
 *   sin alterar el código existente, lo que reduce el riesgo de introducir
 *   errores en el sistema.
 *
 * - **Principio de Inversión de Dependencias (DIP)**: Al utilizar esta interfaz,
 *   las clases que dependen de la implementación de la gestión de proyectos no
 *   dependen de clases concretas, sino de una abstracción. Esto permite cambiar
 *   la implementación sin afectar a las clases que utilizan esta interfaz.
 */
package kodigo.principiossolid.taskmanagement.repository;

import kodigo.principiossolid.taskmanagement.domain.task.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ITaskRepository {

    /**
     * Agrega una tarea al repositorio.
     *
     * @param pTask La tarea a agregar.
     * @return true si la tarea se agregó exitosamente, false en caso contrario.
     */
    boolean addTask(Task pTask);

    /**
     * Busca una tarea por su ID.
     *
     * @param pIdTask El ID de la tarea a buscar.
     * @return Un Optional que contiene la tarea si se encuentra, o vacío si no.
     */
    Optional<Task> findTaskById(UUID pIdTask);

    /**
     * Busca una tarea por su título.
     *
     * @param pTitle El título de la tarea a buscar.
     * @return Un Optional que contiene la tarea si se encuentra, o vacío si no.
     */
    Optional<Task> findTaskByTitle(String pTitle);

    /**
     * Obtiene todas las tareas del repositorio.
     *
     * @return Una lista de todas las tareas.
     */
    List<Task> getAllTasks();

    /**
     * Actualiza una tarea existente en el repositorio.
     *
     * @param pTask La tarea con los datos actualizados.
     * @return true si la tarea se actualizó exitosamente, false en caso contrario.
     */
    boolean updateTask(Task pTask);

    /**
     * Elimina una tarea del repositorio por su ID.
     *
     * @param pIdTask El ID de la tarea a eliminar.
     * @return true si la tarea se eliminó exitosamente, false en caso contrario.
     */
    boolean deleteTask(UUID pIdTask);
}