package kg.alatoo.midterm.repositories;

import kg.alatoo.midterm.entity.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testFindAll() {
        Task task1 = Task.builder().title("Task 1").description("Description for Task 1").isCompleted(false).build();
        Task task2 = Task.builder().title("Task 2").description("Description for Task 2").isCompleted(true).build();
        taskRepository.save(task1);
        taskRepository.save(task2);

        List<Task> tasks = taskRepository.findAll();

        assertThat(tasks.size()).isEqualTo(2);
        assertThat(tasks).contains(task1, task2);
    }

    @Test
    public void testFindById() {

        Task task = Task.builder().title("Task").description("Description").isCompleted(false).build();
        Task savedTask = taskRepository.save(task);

        Optional<Task> optionalTask = taskRepository.findById(savedTask.getTaskId());

        assertThat(optionalTask).isPresent();
        assertThat(optionalTask.get()).isEqualTo(savedTask);
    }
}