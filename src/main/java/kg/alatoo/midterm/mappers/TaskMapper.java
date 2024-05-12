package kg.alatoo.midterm.mappers;

import kg.alatoo.midterm.DTO.TaskDTO;
import kg.alatoo.midterm.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface TaskMapper {

    @Mapping(target = "userId", source = "user.id")
    TaskDTO taskToTaskDTO(Task task);

    @Mapping(target = "user.id", source = "userId")
    Task taskDTOToTask(TaskDTO taskDTO);
}
