package kg.alatoo.midterm.mappers;

import kg.alatoo.midterm.DTO.UserDTO;
import kg.alatoo.midterm.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);
}