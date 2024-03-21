package kg.alatoo.midterm.mappers;

import kg.alatoo.midterm.DTO.UserDTO;
import kg.alatoo.midterm.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = TaskMapper.class)
public interface UserMapper {

    @Mapping(source = "user.tasks", target = "taskIds")
    UserDTO userToUserDTO(User user);

    List<UserDTO> usersToUserDTOs(List<User> users);

    @Mapping(target = "tasks", ignore = true)
    User userDTOToUser(UserDTO userDTO);
}
