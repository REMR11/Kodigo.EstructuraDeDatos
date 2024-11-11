package kodigo.principiossolid.taskmanagement.domain.user;

import kodigo.principiossolid.taskmanagement.domain.task.Task;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private UUID idUser;
    private String name;
    private List<Task> tasks= new ArrayList<>();
}
