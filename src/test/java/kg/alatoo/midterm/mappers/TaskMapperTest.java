package kg.alatoo.midterm.mappers;

import kg.alatoo.midterm.entity.Task;
import kg.alatoo.midterm.DTO.TaskDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTest {

    private TaskMapper taskMapper = Mappers.getMapper(TaskMapper.class);

    @Test
    public void testTaskToTaskDTO() {
        Task task = new Task();
        task.setTitle("Task 1");
        task.setDescription("Description for Task 1");
        task.setCompleted(false);

        TaskDTO taskDTO = taskMapper.taskToTaskDTO(task);

        assertThat(taskDTO.getTitle()).isEqualTo(task.getTitle());
        assertThat(taskDTO.getDescription()).isEqualTo(task.getDescription());
        assertThat(taskDTO.isCompleted()).isEqualTo(task.isCompleted());
    }

}