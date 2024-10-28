/***
 * Clase que implementa la interfaz ITaskRepository,
 * responsable de gestionar las tareas en la aplicación.
 * Esta clase permite realizar operaciones de creación, búsqueda,
 * actualización y eliminación de tareas.
 *
 * Cumple con el Principio de Abierto/Cerrado (OCP) de SOLID,
 * ya que permite la extensión de su funcionalidad a través de la
 * interfaz ITaskRepository, facilitando la creación de nuevas
 * implementaciones sin modificar el código existente.
 */
package kodigo.principiossolid.taskmanagement.repository;

import kodigo.principiossolid.taskmanagement.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@AllArgsConstructor
public class TaskRepository implements ITaskRepository {
    private List<Task> tasks = new ArrayList<>();

    /***
     * Método que agrega una nueva tarea a la lista actual.
     *
     * @param pTask La tarea que se desea agregar.
     * @return true si la tarea fue agregada exitosamente, false en caso contrario.
     */
    @Override
    public boolean AddTask(Task pTask) {
        return tasks.add(pTask);
    }

    /***
     * Método que busca una tarea mediante su ID.
     *
     * @param pIdTask El ID de la tarea que se desea buscar.
     * @return Un Optional<Task> que contiene la tarea si es encontrada, o vacío si no.
     */
    @Override
    public Optional<Task> findTaskById(UUID pIdTask) {
        return tasks.stream()
                .filter(task -> task.getIdTask().equals(pIdTask))
                .findFirst();
    }

    /***
     * Método que busca una tarea mediante su título.
     *
     * @param pTitle El título de la tarea que se desea buscar.
     * @return Un Optional<Task> que contiene la tarea si es encontrada, o vacío si no.
     */
    @Override
    public Optional<Task> fingTaskByTitle(String pTitle) {
        return tasks.stream()
                .filter(task -> task.getTitle().equalsIgnoreCase(pTitle))
                .findFirst();
    }

    /***
     * Método que retorna una lista de todas las tareas registradas.
     *
     * @return Una lista de todas las tareas en el repositorio.
     */
    @Override
    public List<Task> GetAllTasks() {
        return new ArrayList<>(tasks);
    }

    /***
     * Método que actualiza el registro de una tarea existente.
     *
     * @param pTask La tarea con la información actualizada.
     * @return true si la actualización fue exitosa, false si no se encontró la tarea.
     */
    @Override
    public boolean updateTask(Task pTask) {
        Optional<Task> taskOptional = findTaskById(pTask.getIdTask());
        if (taskOptional.isPresent()) {
            Task existingTask = taskOptional.get();
            existingTask.setTitle(pTask.getTitle());
            existingTask.setDescription(pTask.getDescription());
            return true; // Retorna true si la actualización fue exitosa
        }
        return false; // Retorna false si no se encontró la tarea
    }

    /***
     * Método que elimina una tarea mediante su ID.
     *
     * @param pIdTask El ID de la tarea que se desea eliminar.
     * @return true si la eliminación fue exitosa, false si no se encontró la tarea.
     */
    @Override
    public boolean deleteTask(UUID pIdTask) {
        return tasks.removeIf(task -> task.getIdTask().equals(pIdTask));
    }
}