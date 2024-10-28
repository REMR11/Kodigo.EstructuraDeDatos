package kodigo.principiossolid.taskmanagement.repository;

import kodigo.principiossolid.taskmanagement.domain.Project;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProjectRepository {
    boolean save(Project pProject);
    Optional<Project> findById(UUID pIdProject);
    Optional<Project> findByName(String pProjectName);
    List<Project> findAll();
    boolean updateProject(Project pProject);
    boolean delete(UUID pIdProject);
}
