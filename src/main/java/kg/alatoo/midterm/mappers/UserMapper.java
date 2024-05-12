package kg.alatoo.midterm.mappers;

import kg.alatoo.midterm.DTO.UserDTO;
import kg.alatoo.midterm.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TaskMapper.class)
public interface UserMapper {

    UserDTO userToUserDTO(User user);

    @Mapping(target = "password", ignore = true)
    User userDTOToUser(UserDTO userDTO);
}
