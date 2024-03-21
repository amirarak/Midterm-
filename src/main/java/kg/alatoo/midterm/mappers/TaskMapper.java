package kg.alatoo.midterm.mappers;

import kg.alatoo.midterm.DTO.TaskDTO;
import kg.alatoo.midterm.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "userId", source = "task.userID")
    @Mapping(target = "userName", source = "task.userName.name")
    TaskDTO taskToTaskDTO(Task task);
}