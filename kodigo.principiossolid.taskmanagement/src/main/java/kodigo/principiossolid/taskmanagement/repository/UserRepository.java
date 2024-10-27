package kodigo.principiossolid.taskmanagement.repository;

import kodigo.principiossolid.taskmanagement.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepository implements IUserRepository{
    private List<User> users = new ArrayList<>();
    /**
     * @param pUser
     * @return
     */
    @Override
    public boolean save(User pUser) {
        return users.add(pUser);
    }

    /**
     * @param pidUser
     * @return
     */
    @Override
    public Optional<User> findById(UUID pidUser) {
        return users.stream()
                .filter(user -> user.getIdUser().equals(pidUser))
                .findFirst();
    }

    /**
     * @return
     */
    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    /**
     * @param pUser
     * @return
     */
    @Override
    public boolean delete(User pUser) {
        return users.removeIf(user -> user.getIdUser().equals(pUser.getIdUser()));
    }
}
