package kodigo.principiossolid.taskmanagement.repository;

import kodigo.principiossolid.taskmanagement.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserRepository {
    boolean save(User pUser);
    Optional<User> findById(UUID pUuid);
    List<User> findAll();
    boolean UpdateUser(User pUser);
    boolean delete(UUID pIdUser);
}
