/**
 * Interfaz que define las operaciones para la gestión de proyectos.
 *
 * Esta interfaz cumple con el siguiente principio SOLID:
 *
 * - **Principio de Responsabilidad Única (SRP)**: Cada método de esta interfaz
 *   se encarga de una única responsabilidad relacionada con la gestión de proyectos,
 *   como guardar, buscar, actualizar y eliminar proyectos.
 *
 * - **Principio de Inversión de Dependencias (DIP)**: Al utilizar esta interfaz,
 *   las clases que dependen de la implementación de la gestión de proyectos no
 *   dependen de clases concretas, sino de una abstracción. Esto permite cambiar
 *   la implementación sin afectar a las clases que utilizan esta interfaz.
 */
package kodigo.principiossolid.taskmanagement.repository;

import kodigo.principiossolid.taskmanagement.domain.project.Project;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface IProjectRepository {

    /**
     * Guarda un proyecto en el repositorio.
     *
     * @param pProject El proyecto a guardar.
     * @return true si el proyecto se guardó exitosamente, false en caso contrario.
     */
    boolean save(Project pProject);

    /**
     * Busca un proyecto por su ID.
     *
     * @param pIdProject El ID del proyecto a buscar.
     * @return Un Optional que contiene el proyecto si se encuentra, o vacío si no.
     */
    Optional<Project> findById(UUID pIdProject);

    /**
     * Busca un proyecto por su nombre.
     *
     * @param pProjectName El nombre del proyecto a buscar.
     * @return Un Optional que contiene el proyecto si se encuentra, o vacío si no.
     */
    Optional<Project> findByName(String pProjectName);

    /**
     * Obtiene todos los proyectos del repositorio.
     *
     * @return Una lista de todos los proyectos.
     */
    List<Project> findAll();

    /**
     * Actualiza un proyecto existente en el repositorio.
     *
     * @param pProject El proyecto con los datos actualizados.
     * @return true si el proyecto se actualizó exitosamente, false en caso contrario.
     */
    boolean updateProject(Project pProject);

    /**
     * Elimina un proyecto del repositorio por su ID.
     *
     * @param pIdProject El ID del proyecto a eliminar.
     * @return true si el proyecto se eliminó exitosamente, false en caso contrario.
     */
    boolean delete(UUID pIdProject);
}