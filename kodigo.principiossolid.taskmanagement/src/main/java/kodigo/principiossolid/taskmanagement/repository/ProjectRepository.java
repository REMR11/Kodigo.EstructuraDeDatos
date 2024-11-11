/***
 * Clase que implementa la interfaz IProjectRepository,
 * responsable de gestionar los proyectos en la aplicación.
 * Esta clase permite realizar operaciones de creación, búsqueda,
 * actualización y eliminación de proyectos.
 *
 * Cumple con el Principio de Abierto/Cerrado (OCP) de SOLID,
 * ya que permite la extensión de su funcionalidad a través de la
 * interfaz IProjectRepository, facilitando la creación de nuevas
 * implementaciones sin modificar el código existente.
 */
package kodigo.principiossolid.taskmanagement.repository;

import kodigo.principiossolid.taskmanagement.domain.project.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProjectRepository implements IProjectRepository {
    private List<Project> projects = new ArrayList<>();

    /***
     * Método que guarda un nuevo proyecto en el repositorio.
     *
     * @param pProject El proyecto que se desea guardar.
     * @return true si el proyecto fue guardado exitosamente, false en caso contrario.
     */
    @Override
    public boolean save(Project pProject) {
        return projects.add(pProject);
    }

    /**
     * @param pIdProject
     * @return
     */
    @Override
    public Optional<Project> findById(UUID pIdProject) {
        return projects.stream()
                .filter(project -> project.getIdProject().equals(pIdProject))
                .findFirst();
    }

    /***
     * Método que busca un proyecto por su nombre.
     *
     * @param pProjectName El nombre del proyecto que se desea buscar.
     * @return Un Optional<Project> que contiene el proyecto si es encontrado, o vacío si no.
     */
    @Override
    public Optional<Project> findByName(String pProjectName) {
        return projects.stream()
                .filter(project -> project.getName().equalsIgnoreCase(pProjectName))
                .findFirst();
    }

    /***
     * Método que recupera todos los proyectos registrados.
     *
     * @return Una lista de todos los proyectos en el repositorio.
     */
    @Override
    public List<Project> findAll() {
        return new ArrayList<>(projects);
    }

    /***
     * Método que actualiza un proyecto existente en el repositorio.
     *
     * @param pProject El proyecto con la información actualizada.
     * @return true si la actualización fue exitosa, false si el proyecto no fue encontrado.
     */
    @Override
    public boolean updateProject(Project pProject) {
        Optional<Project> projectOptional = findByName(pProject.getName());
        if (projectOptional.isPresent()) {
            Project projectPresent = projectOptional.get();
            projectPresent.setName(pProject.getName());
            projectPresent.setTasks(pProject.getTasks());
            return true; // Retorna true si la actualización fue exitosa
        }
        return false; // Retorna false si no se encontró el proyecto
    }

    /***
     * Método que elimina un proyecto del repositorio.
     *
     * @param pIdProject Id del proyecto que se desea eliminar.
     * @return true si la eliminación fue exitosa, false si el proyecto no fue encontrado.
     */
    @Override
    public boolean delete(UUID pIdProject) {
        return projects.removeIf(project -> project.getIdProject().equals(pIdProject));
    }
}