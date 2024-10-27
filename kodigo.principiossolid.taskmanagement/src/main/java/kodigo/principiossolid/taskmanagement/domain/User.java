package kodigo.principiossolid.taskmanagement.domain;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private UUID idUser;
    private String name;
    private List<Task> tasks;
}
