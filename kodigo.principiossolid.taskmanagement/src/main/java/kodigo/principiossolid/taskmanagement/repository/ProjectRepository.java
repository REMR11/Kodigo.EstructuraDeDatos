package kodigo.principiossolid.taskmanagement.repository;

import kodigo.principiossolid.taskmanagement.domain.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProjectRepository implements IProjectRepositoy{
    private List<Project> projects = new ArrayList<>();
    /**
     * @param pProject
     * @return
     */
    @Override
    public boolean save(Project pProject) {
        return projects.add(pProject);
    }

    /**
     * @param pProjectName
     * @return
     */
    @Override
    public Optional<Project> findById(String pProjectName) {
        return projects.stream()
                .filter(project -> project.getName().equalsIgnoreCase(pProjectName))
                .findFirst();
    }

    /**
     * @return
     */
    @Override
    public List<Project> findAll() {
        return new ArrayList<>(projects);
    }

    /**
     * @param pProject
     * @return
     */
    @Override
    public boolean delete(Project pProject) {
        return projects.removeIf(project -> project.getName().equalsIgnoreCase(project.getName()));
    }
}
