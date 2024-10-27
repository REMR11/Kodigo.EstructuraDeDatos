/***
 * Clase que implementa la interfaz ITaskRepositoriy,
 * con el fin de cumplir con el principio Open Closed
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
public class TaskRepository implements ITaskRepository{
    private List<Task> tasks = new ArrayList<>();


    /***
     * Metodo con logica para agregar una nueva tarea a la lista actual.
     * @param pTask
     * @return boolean que verifica si se agrega la nueva tarea en la lista.
     */
    @Override
    public boolean AddTask(Task pTask) {
        return tasks.add(pTask);
    }

    /***
     * Metodo con la logica necesaria para buscar una tarea mediante el Id.
     * @param pIdTask
     * @return Optional<Task> si la tarea es encontrada.
     */
    @Override
    public Optional<Task> searchTaskById(UUID pIdTask) {
        return tasks.stream()
                .filter(task -> task.getIdTask().equals(pIdTask))
                .findFirst();
    }

    /***
     * Metodo con la logica necesaria para buscar una tarea mediante el Titylo.
     * @param pTitle
     * @return Optional<Task> si la tarea es encontrada
     */
    @Override
    public Optional<Task> searchTaskByTitle(String pTitle) {
        return tasks.stream()
                .filter(task -> task.getTitle().equalsIgnoreCase(pTitle))
                .findFirst();
    }

    /**
     * Metodo que retorna una lista de tareas registradas.
     * @return List de todas las tareas en el arreglo.
     */
    @Override
    public List<Task> GetAllTasks() {
        return new ArrayList<>(tasks);
    }

    /***
     * Metodo con la logica necesaria para actualizar el registro de una tarea existente.
     * @param pTask necesario para la busqueda y modificacion de la tarea.
     * @return boolean que verifica si la actualizacion fue exitosa.
     */
    @Override
    public boolean updateTask(Task pTask) {
        Optional<Task> taskOptional = searchTaskById(pTask.getIdTask());
        if (taskOptional.isPresent()) {
            Task existingTask = taskOptional.get();
            existingTask.setTitle(pTask.getTitle());
            existingTask.setDescription(pTask.getDescription());
            return true; // Retorna true si la actualización fue exitosa
        }
        return false; // Retorna false si no se encontró la tarea
    }

    /**
     * Metodo para la eliminacion de una tarea mediante Id
     * @param pIdTask
     * @return boolean que verifica el exito de la eliminacion.
     */
    @Override
    public boolean deleteTask(UUID pIdTask) {
        return tasks.removeIf(task -> task.getIdTask().equals(pIdTask));
    }
}
