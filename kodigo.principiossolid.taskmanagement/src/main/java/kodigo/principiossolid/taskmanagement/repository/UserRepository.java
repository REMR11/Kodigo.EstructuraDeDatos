/***
 * Clase UserRepository que implementa la interfaz IUserRepository.
 * Esta clase es responsable de la gestión de usuarios en la aplicación,
 * incluyendo la creación, búsqueda, actualización y eliminación de usuarios.
 *
 * Cumple con el Principio de Responsabilidad Única (SRP) de SOLID,
 * ya que se encarga exclusivamente de las operaciones relacionadas con los usuarios.
 *
 * Además, cumple con el Principio de Abierto/Cerrado (OCP) de SOLID,
 * ya que permite la extensión de su funcionalidad a través de la interfaz IUserRepository.
 */
package kodigo.principiossolid.taskmanagement.repository;

import kodigo.principiossolid.taskmanagement.domain.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepository implements IUserRepository {

    private List<User> users = new ArrayList<>();

    /**
     * Guarda un nuevo usuario en el repositorio.
     *
     * @param pUser   El usuario que se desea guardar.
     * @return true si el usuario fue guardado exitosamente, false en caso contrario.
     */
    @Override
    public boolean save(User pUser  ) {
        return users.add(pUser  );
    }

    /**
     * Busca un usuario por su ID.
     *
     * @param pidUser   El ID del usuario que se desea buscar.
     * @return Un Optional que contiene el usuario si se encuentra, o vacío si no se encuentra.
     */
    @Override
    public Optional<User> findById(UUID pidUser  ) {
        return users.stream()
                .filter(user -> user.getIdUser  ().equals(pidUser  ))
                .findFirst();
    }

    /**
     * Recupera todos los usuarios del repositorio.
     *
     * @return Una lista de todos los usuarios.
     */
    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    /**
     * Actualiza la información de un usuario existente en el repositorio.
     *
     * @param pUser   El usuario con la información actualizada.
     * @return true si el usuario fue actualizado exitosamente, false si el usuario no existe.
     */
    @Override
    public boolean updateUser(User pUser) {
        Optional<User> existingUser   = findById(pUser  .getIdUser  ());

        if (existingUser  .isPresent()) {
            User pExistingUser   = existingUser  .get();
            pExistingUser  .setName(pUser  .getName());
            pExistingUser  .setTasks(pUser  .getTasks());
            return true;
        }

        return false;
    }
    /**
     * Elimina un usuario del repositorio.
     *
     * @param pIdUser del usuario que se desea eliminar.
     * @return true si el usuario fue eliminado exitosamente, false si el usuario no existe.
     */
    @Override
    public boolean delete(UUID pIdUser) {
        return users.removeIf(user -> user.getIdUser().equals(pIdUser));
    }
}