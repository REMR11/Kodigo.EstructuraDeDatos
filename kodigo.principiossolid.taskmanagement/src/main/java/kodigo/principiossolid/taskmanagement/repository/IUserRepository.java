/**
 * Interfaz que define las operaciones para la gestión de usuarios.
 *
 * Esta interfaz cumple con los siguientes principios SOLID:
 *
 * - **Principio de Responsabilidad Única (SRP)**: Cada método de esta interfaz
 *   se encarga de una única responsabilidad relacionada con la gestión de usuarios,
 *   como guardar, buscar, actualizar y eliminar usuarios.
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

import kodigo.principiossolid.taskmanagement.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserRepository {

    /**
     * Guarda un usuario en el repositorio.
     *
     * @param pUser  El usuario a guardar.
     * @return true si el usuario se guardó exitosamente, false en caso contrario.
     */
    boolean save(User pUser );

    /**
     * Busca un usuario por su ID.
     *
     * @param pUuid El ID del usuario a buscar.
     * @return Un Optional que contiene el usuario si se encuentra, o vacío si no.
     */
    Optional<User> findById(UUID pUuid);

    /**
     * Obtiene todos los usuarios del repositorio.
     *
     * @return Una lista de todos los usuarios.
     */
    List<User> findAll();

    /**
     * Actualiza un usuario existente en el repositorio.
     *
     * @param pUser  El usuario con los datos actualizados.
     * @return true si el usuario se actualizó exitosamente, false en caso contrario.
     */
    boolean updateUser (User pUser );

    /**
     * Elimina un usuario del repositorio por su ID.
     *
     * @param pIdUser  El ID del usuario a eliminar.
     * @return true si el usuario se eliminó exitosamente, false en caso contrario.
     */
    boolean delete(UUID pIdUser );
}