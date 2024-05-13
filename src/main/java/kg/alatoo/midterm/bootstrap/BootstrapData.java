package kg.alatoo.midterm.bootstrap;

import kg.alatoo.midterm.entity.Roles;
import kg.alatoo.midterm.entity.Task;
import kg.alatoo.midterm.entity.User;
import kg.alatoo.midterm.repositories.TaskRepository;
import kg.alatoo.midterm.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public BootstrapData(TaskRepository taskRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        User admin = User.builder()
                .name("Amira")
                .username("admin")
                .roles(Set.of(Roles.ADMIN, Roles.STAFF))
                .password(passwordEncoder.encode("pass"))
                .build();
        User staff = User.builder()
                .name("Staff")
                .username("staff")
                .password(passwordEncoder.encode("pass"))
                .roles(Set.of(Roles.STAFF))
                .build();
        userRepository.saveAll(List.of(admin, staff));

        Set<User> users = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            User user = User.builder()
                    .name("User " + i)
                    .username("user" + i)
                    .roles(Set.of(Roles.USER))
                    .password(passwordEncoder.encode("pass"))
                    .build();
            users.add(user);
        }
        userRepository.saveAll(users);

        // Create orders for each user
        Set<Task> tasks = new HashSet<>();
        for (User user : users) {
            Task order = Task.builder()
                    .user(user)
                    .title("Task #1")
                    .isCompleted(false)
                    .description("Task for " + user.getName())
                    .build();
            tasks.add(order);
        }
        taskRepository.saveAll(tasks);
    }
}
