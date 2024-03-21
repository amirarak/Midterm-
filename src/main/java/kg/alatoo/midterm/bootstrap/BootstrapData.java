package kg.alatoo.midterm.bootstrap;

import kg.alatoo.midterm.entity.Task;
import kg.alatoo.midterm.entity.User;
import kg.alatoo.midterm.repositories.TaskRepository;
import kg.alatoo.midterm.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BootstrapData implements CommandLineRunner {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public BootstrapData(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = User.builder().name("John").build();
        User user2 = User.builder().name("Alice").build();

        userRepository.saveAll(Arrays.asList(user1, user2));

        Task task1 = Task.builder().title("Task 1").description("Description for Task 1").isCompleted(false).user(user1).build();
        Task task2 = Task.builder().title("Task 2").description("Description for Task 2").isCompleted(true).user(user1).build();
        Task task3 = Task.builder().title("Task 3").description("Description for Task 3").isCompleted(false).user(user2).build();

        taskRepository.saveAll(Arrays.asList(task1, task2, task3));
    }
}