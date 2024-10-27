package kodigo.principiossolid.taskmanagement.domain;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private List<Task> tasks;
}
