package kg.alatoo.midterm.mappers;

import kg.alatoo.midterm.DTO.TaskDTO;
import kg.alatoo.midterm.entity.Task;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskMapperTest {

    private final TaskMapper taskMapper = Mappers.getMapper(TaskMapper.class);

    @Test
    public void testToTaskDTO() {
        // Given
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Test Task");
        task.setDescription("Description for Test Task");
        task.setCompleted(false);

        // When
        TaskDTO taskDTO = taskMapper.toTaskDTO(task);

        // Then
        assertThat(taskDTO).isNotNull();
        assertThat(taskDTO.getId()).isEqualTo(1L);
        assertThat(taskDTO.getTitle()).isEqualTo("Test Task");
    }
}