/***
 * Principio de inversion de dependencias
 * Se utiliza TaskRepository, UserRepository y ProjectRepository como dependencias para la clase
 * TaskManager, en este caso  TaskManager depende de una abstraccion,
 * no directamente de una implementacion directa.
 */
package kodigo.principiossolid.taskmanagement.service;

import kodigo.principiossolid.taskmanagement.domain.Project;
import kodigo.principiossolid.taskmanagement.domain.Task;
import kodigo.principiossolid.taskmanagement.domain.User;
import kodigo.principiossolid.taskmanagement.repository.ProjectRepository;
import kodigo.principiossolid.taskmanagement.repository.TaskRepository;
import kodigo.principiossolid.taskmanagement.repository.UserRepository;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class TaskManager {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    /**
     * Asigna una tarea a un usuario dado su ID.
     *
     * @param pIdTask ID de la tarea que se desea asignar.
     * @param pIdUser  ID del usuario al que se asignará la tarea.
     * @return true si la tarea fue asignada exitosamente, false en caso contrario.
     */
    public boolean assingTaskToUser(UUID pIdTask,UUID pIdUser){
        Optional<User> userOptional = userRepository.findById(pIdUser);
        Optional<Task> taskOptional = taskRepository.findTaskById(pIdTask);
        if(userOptional.isPresent() && taskOptional.isPresent()){
            Task task = taskOptional.get();
            User user = userOptional.get();
            user.getTasks().add(task);
            return userRepository.UpdateUser(user);
        }
        return false;
    }

    /**
     * Asigna una tarea a un proyecto dado su título.
     *
     * @param pIdProject Id del proyecto al que se asignará la tarea.
     * @param pIdTask Id de la tarea que se desea asignar al proyecto.
     * @return true si la tarea fue asignada exitosamente al proyecto, false en caso contrario.
     */
    public boolean assignTaskToProject(UUID pIdProject, UUID pIdTask){
        Optional<Project> projectOptional =  projectRepository.findById( pIdProject );
        Optional<Task> taskOptional = taskRepository.findTaskById( pIdTask );

        if( projectOptional.isPresent() && taskOptional.isPresent() ){
            Project projectPresent = projectOptional.get();
            Task taskPresent = taskOptional.get();
            projectPresent.getTasks().add( taskPresent );
            return projectRepository.updateProject( projectPresent );
        }
        return false;
    }

    /**
     * Obtiene una lista de todas las tareas.
     *
     * @return Una lista de todas las tareas disponibles en el repositorio.
     */
    public List<Task> getAllTask() {
        return taskRepository.GetAllTasks();
    }

    public List<User> getAllUserByIdTask(UUID pIdTask){
        List<User> users = userRepository.findAll();

        return users.stream()
                    .filter(user -> user.getTasks().stream()
                        .anyMatch(task -> task.getIdTask().equals(pIdTask)))
                    .collect(Collectors.toList());
    }
    /**
     * Busca una tarea por su ID.
     *
     * @param pIdTask ID de la tarea que se desea buscar.
     * @return Un Optional que contiene la tarea si se encuentra, o vacío si no se encuentra.
     */
    public Optional<Task> getTaskById(UUID pIdTask) {
        return taskRepository.findTaskById(pIdTask);
    }

    /**
     * Obtiene información sobre un proyecto, incluyendo los usuarios asignados a cada tarea.
     *
     * @param pIdProject ID del proyecto cuyo información se desea obtener.
     */
    public void getInformationProject(UUID pIdProject) {
        Optional<Project> projectOptional = projectRepository.findById(pIdProject);
        if (projectOptional.isPresent()) {
            Project projectPresent = projectOptional.get();
            List<Task> tasks = projectPresent.getTasks();

            Map<Task, List<User>> taskUsersMap = new HashMap<>();

            for (Task task : tasks) {
                List<User> usersForTask = getAllUserByIdTask(task.getIdTask());
                taskUsersMap.put(task, usersForTask);
            }

            taskUsersMap.forEach((task, users) -> {
                System.out.println("Tarea: " + task.getIdTask());
                System.out.println("Usuarios asignados: " + users);
            });
        } else {
            System.out.println("El proyecto no fue encontrado.");
        }
    }

    /**
     * Elimina una tarea por su ID.
     *
     * @param pIdTaks ID de la tarea que se desea eliminar.
     * @return true si la tarea fue eliminada exitosamente, false en caso contrario.
     */
    public boolean deleteTask(UUID pIdTaks) {
        return taskRepository.deleteTask(pIdTaks);
    }

     /**
     * Elimina un usuario por su ID.
     *
     * @param pIdUser ID del usuario que se desea eliminar.
     * @return true si el usuario fue  eliminada exitosamente, false en caso contrario.
     */
    public boolean deleteUser(UUID pIdUser){
        return userRepository.delete(pIdUser);
    }

    /**
     * Elimina un proyecto por su ID.
     *
     * @param pIdProject ID del proyecto que se desea eliminar.
     * @return true si el proyecto fue  eliminada exitosamente, false en caso contrario.
     */
    public boolean deleteProject(UUID pIdProject){
        return projectRepository.delete(pIdProject);
    }
    /**
     * Actualiza una tarea.
     *
     * @param pTask Tarea que se desea actualizar.
     * @return true si la tarea fue actualizada exitosamente, false en caso contrario.
     */
    public boolean updateTask(Task pTask) {
        return taskRepository.updateTask(pTask);
    }
}
