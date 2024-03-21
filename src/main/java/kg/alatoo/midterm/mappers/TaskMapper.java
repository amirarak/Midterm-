package kg.alatoo.midterm.mappers;

import kg.alatoo.midterm.DTO.TaskDTO;
import kg.alatoo.midterm.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(source = "user.id", target = "userId")
    TaskDTO toTaskDTO(Task task);
}