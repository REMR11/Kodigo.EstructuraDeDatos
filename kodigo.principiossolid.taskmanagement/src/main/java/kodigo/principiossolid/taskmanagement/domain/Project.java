package kodigo.principiossolid.taskmanagement.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Project {
    private UUID idProject;
    private String name;
    private List<Task> tasks = new ArrayList<>();
}
