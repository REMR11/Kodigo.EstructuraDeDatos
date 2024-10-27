package kodigo.principiossolid.taskmanagement.repository;

import kodigo.principiossolid.taskmanagement.domain.Project;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProjectRepositoy {
    boolean save(Project pProject);
    Optional<Project> findById(String pProjectName);
    List<Project> findAll();
    boolean delete(Project pProject);
}
