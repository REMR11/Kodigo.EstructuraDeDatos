/**
 * Clase principal del sistema de gestión de tareas.
 * Proporciona una interfaz de consola para interactuar con las funcionalidades del sistema,
 * permitiendo la creación, asignación y visualización de tareas, usuarios y proyectos.
 */

package kodigo.principiossolid.taskmanagement;

import kodigo.principiossolid.taskmanagement.domain.project.Project;
import kodigo.principiossolid.taskmanagement.domain.task.PriorityTask;
import kodigo.principiossolid.taskmanagement.domain.task.RecurringTask;
import kodigo.principiossolid.taskmanagement.domain.task.Task;
import kodigo.principiossolid.taskmanagement.domain.user.User;
import kodigo.principiossolid.taskmanagement.repository.IUserRepository;
import kodigo.principiossolid.taskmanagement.repository.ProjectRepository;
import kodigo.principiossolid.taskmanagement.repository.TaskRepository;
import kodigo.principiossolid.taskmanagement.repository.UserRepository;
import kodigo.principiossolid.taskmanagement.service.TaskManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

/***
 * @Author Ronald Eduardo Mejia Reinosa
 *
 */
public class Main {

    /**
     * Método principal que ejecuta el menú de la aplicación de gestión de tareas.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();

        TaskRepository taskRepository = new TaskRepository(tasks);
        UserRepository userRepository = new UserRepository();
        ProjectRepository projectRepository = new ProjectRepository();

        TaskManager taskManager = new TaskManager(taskRepository, userRepository, projectRepository);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTask Management System");
            System.out.println("1. Create User");
            System.out.println("2. Create Priority Task");
            System.out.println("3. Create Recurring Task");
            System.out.println("4. Create Project");
            System.out.println("5. Assign Task to User");
            System.out.println("6. Assign Task to Project");
            System.out.println("7. View All Users");
            System.out.println("8. View All Tasks");
            System.out.println("9. View Task by ID");
            System.out.println("10. View All Projects");
            System.out.println("11. Get Project Information");
            System.out.println("12. Update Task");
            System.out.println("13. Delete Task");
            System.out.println("14. Delete User");
            System.out.println("15. Delete Project");
            System.out.println("16. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (option) {
                case 1:
                    createUser (scanner, userRepository);
                    break;
                case 2:
                    createPriorityTask(scanner, taskRepository);
                    break;
                case 3:
                    createRecurringTask(scanner, taskRepository);
                    break;
                case 4:
                    createProject(scanner, projectRepository);
                    break;
                case 5:
                    assignTaskToUser (scanner, taskManager);
                    break;
                case 6:
                    assignTaskToProject(scanner, taskManager);
                    break;
                case 7:
                    viewAllUsers(userRepository);
                    break;
                case 8:
                    viewAllTasks(taskManager);
                    break;
                case 9:
                    viewTaskById(scanner, taskManager);
                    break;
                case 10:
                    viewAllProjects(projectRepository);
                    break;
                case 11:
                    getProjectInformation(scanner, taskManager);
                    break;
                case 12:
                    updateTask(scanner, taskManager);
                    break;
                case 13:
                    deleteTask(scanner, taskManager);
                    break;
                case 14:
                    deleteUser (scanner, taskManager);
                    break;
                case 15:
                    deleteProject(scanner, taskManager);
                    break;
                case 16:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void viewAllUsers(UserRepository userRepository) {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            System.out.println("Tasks:");
            users.forEach(user -> System.out.println("ID: " + user.getIdUser() + ", name: " + user.getName()+", tasks:"+user.getTasks()));
        }
    }

    /**
     * Crea una nueva tarea prioritarua en el sistema.
     * @param scanner Entrada de usuario para la consola.
     * @param taskRepository Repositorio de tareas donde se almacenará la nueva tarea.
     */
    private static void createPriorityTask(Scanner scanner, TaskRepository taskRepository) {
        System.out.println("Enter task name: ");
        String name = scanner.nextLine();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        LocalDate now = LocalDate.now();

        System.out.println("Enter the priority of the task (1 = high, 2 = medium, 3 = low): ");
        int priority = scanner.nextInt();
        scanner.nextLine();

        Task task = new PriorityTask(name,description,now, priority);
        taskRepository.addTask(task);
        System.out.println("Task created with ID: " + task.getIdTask());
    }
    /**
     * Crea una nueva tarea prioritarua en el sistema.
     * @param scanner Entrada de usuario para la consola.
     * @param taskRepository Repositorio de tareas donde se almacenará la nueva tarea.
     */
    private static void createRecurringTask(Scanner scanner, TaskRepository taskRepository) {
        System.out.println("Enter task name: ");
        String name = scanner.nextLine();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        System.out.println("Enter the start date of the task (YYYY-MM-DDTHH:MM): ");
        String dateInput = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(dateInput); // Asegúrate de que el formato sea correcto

        System.out.println("Enter the recurrence unit (1 = DAYS, 2 = WEEKS, 3 = MONTHS): ");
        int unitChoice = scanner.nextInt();

        ChronoUnit recurrenceUnit = promptForRecurrenceUnit(scanner);

        System.out.println("Enter the recurrence interval: ");
        int recurrenceInterval = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        // Crear la tarea recurrente
        Task task = new RecurringTask(name, description, startDate, recurrenceUnit, recurrenceInterval);
        taskRepository.addTask(task);
        System.out.println("Recurring task created with ID: " + task.getIdTask());
    }

    private static ChronoUnit promptForRecurrenceUnit(Scanner scanner) {
        System.out.println("Enter the recurrence unit (1 = DAYS, 2 = WEEKS, 3 = MONTHS): ");
        int unitChoice = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        switch (unitChoice) {
            case 1: return ChronoUnit.DAYS;
            case 2: return ChronoUnit.WEEKS;
            case 3: return ChronoUnit.MONTHS;
            default:
                System.out.println("Invalid choice. Defaulting to DAYS.");
                return ChronoUnit.DAYS;
        }
    }

    /**
     * Crea un nuevo usuario en el sistema.
     * @param scanner Entrada de usuario para la consola.
     * @param userRepository Repositorio de usuarios donde se almacenará el nuevo usuario.
     */
    private static void createUser(Scanner scanner, IUserRepository userRepository) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        User user = new User(UUID.randomUUID(), name, new ArrayList<>());
        userRepository.save(user);
        System.out.println("User created with ID: " + user.getIdUser());
    }

    /**
     * Asigna una tarea a un usuario específico.
     * @param scanner Entrada de usuario para la consola.
     * @param taskManager Instancia de TaskManager para manejar la asignación de tareas.
     */
    private static void assignTaskToUser(Scanner scanner, TaskManager taskManager) {
        System.out.print("Enter task ID to assign: ");
        UUID taskId = UUID.fromString(scanner.nextLine());

        System.out.print("Enter user ID to assign to: ");
        UUID userId = UUID.fromString(scanner.nextLine());

        try {
            taskManager.assingTaskToUser(taskId, userId);
            System.out.println("Task assigned successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra todas las tareas almacenadas en el sistema.
     * @param taskManager Instancia de TaskManager para obtener todas las tareas.
     */
    private static void viewAllTasks(TaskManager taskManager) {
        List<Task> tasks = taskManager.getAllTask();
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            tasks.forEach(task -> System.out.println("ID: " + task.getIdTask() + ", Description: " + task.getDescription()));
        }
    }

    /**
     * Muestra la información de una tarea específica según su ID.
     * @param scanner Entrada de usuario para la consola.
     * @param taskManager Instancia de TaskManager para buscar la tarea.
     */
    private static void viewTaskById(Scanner scanner, TaskManager taskManager) {
        System.out.print("Enter task ID: ");
        UUID taskId = UUID.fromString(scanner.nextLine());

        Optional<Task> taskOpt = taskManager.getTaskById(taskId);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            System.out.println("Task ID: " + task.getIdTask());
            System.out.println("Description: " + task.getDescription());
        } else {
            System.out.println("Task not found.");
        }
    }

    /**
     * Crea un nuevo proyecto en el sistema.
     * @param scanner Entrada de usuario para la consola.
     * @param projectRepository Repositorio de proyectos donde se almacenará el nuevo proyecto.
     */
    private static void createProject(Scanner scanner, ProjectRepository projectRepository) {
        System.out.print("Enter project name: ");
        String name = scanner.nextLine();
        Project project = new Project(UUID.randomUUID(), name, new ArrayList<>());
        projectRepository.save(project);
        System.out.println("Project created with ID: " + project.getIdProject());
    }

    /**
     * Asigna una tarea a un proyecto específico.
     * @param scanner Entrada de usuario para la consola.
     * @param taskManager Instancia de TaskManager para manejar la asignación de tareas al proyecto.
     */
    private static void assignTaskToProject(Scanner scanner, TaskManager taskManager) {
        System.out.print("Enter task ID to assign to project: ");
        UUID taskId = UUID.fromString(scanner.nextLine());

        System.out.print("Enter project ID to assign task to: ");
        UUID projectId = UUID.fromString(scanner.nextLine());

        try {
            taskManager.assignTaskToProject(taskId, projectId);
            System.out.println("Task assigned to project successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra todos los proyectos almacenados en el sistema.
     * @param projectRepository Repositorio de proyectos para obtener todos los proyectos.
     */
    private static void viewAllProjects(ProjectRepository projectRepository) {
        List<Project> projects = projectRepository.findAll();
        if (projects.isEmpty()) {
            System.out.println("No projects available.");
        } else {
            System.out.println("Projects:");
            projects.forEach(project -> System.out.println("ID: " + project.getIdProject() + ", Name: " + project.getName()));
        }
    }

    /**
     * Muestra la información detallada de un proyecto, incluyendo sus tareas y usuarios asignados.
     * @param scanner Entrada de usuario para la consola.
     * @param taskManager Instancia de TaskManager para obtener la información del proyecto.
     */
    private static void getProjectInformation(Scanner scanner, TaskManager taskManager) {
        System.out.print("Enter project ID to view information: ");
        UUID projectId = UUID.fromString(scanner.nextLine());

        taskManager.getInformationProject(projectId);
    }

    /**
     * Actualiza una tarea en el sistema.
     * @param scanner 4Entrada de usuario para la consola.
     * @param taskManager Instancia de TaskManager para manejar la actualización de tareas.
     */
    private static void updateTask(Scanner scanner, TaskManager taskManager) {
        System.out.print("Enter task ID to update: ");
        UUID taskId = UUID.fromString(scanner.nextLine());

        Optional<Task> taskOpt = taskManager.getTaskById(taskId);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();

            System.out.print("Enter new task name (leave blank to keep current): ");
            String newName = scanner.nextLine();
            if (!newName.isBlank()) {
                task.setTitle(newName);
            }

            System.out.print("Enter new task description (leave blank to keep current): ");
            String newDescription = scanner.nextLine();
            if (!newDescription.isBlank()) {
                task.setDescription(newDescription);
            }

            System.out.print("Is the task completed? (true/false, leave blank to keep current): ");
            String isCompleted = scanner.nextLine();
            if (!isCompleted.isBlank()) {
                task.setCompleted(Boolean.parseBoolean(isCompleted));
            }

            taskManager.updateTask(task);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    /**
     * Elimina una tarea en el sistema.
     * @param scanner Entrada de usuario para la consola.
     * @param taskManager Instancia de TaskManager para manejar la eliminación de tareas.
     */
    private static void deleteTask(Scanner scanner, TaskManager taskManager) {
        System.out.print("Enter task ID to delete: ");
        UUID taskId = UUID.fromString(scanner.nextLine());

        if (taskManager.deleteTask(taskId)) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    /**
     * Elimina un usuario en el sistema.
     * @param scanner Entrada de usuario para la consola.
     * @param taskManager Instancia de TaskManager para manejar la eliminación de usuarios.
     */
    private static void deleteUser(Scanner scanner, TaskManager taskManager) {
        System.out.print("Enter user ID to delete: ");
        UUID userId = UUID.fromString(scanner.nextLine());

        if (taskManager.deleteUser(userId)) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    /**
     * Elimina un proyecto en el sistema.
     * @param scanner Entrada de usuario para la consola.
     * @param taskManager Instancia de TaskManager para manejar la eliminación de proyectos.
     */
    private static void deleteProject(Scanner scanner, TaskManager taskManager) {
        System.out.print("Enter project ID to delete: ");
        UUID projectId = UUID.fromString(scanner.nextLine());

        if (taskManager.deleteProject(projectId)) {
            System.out.println("Project deleted successfully.");
        } else {
            System.out.println("Project not found.");
        }
    }

}
