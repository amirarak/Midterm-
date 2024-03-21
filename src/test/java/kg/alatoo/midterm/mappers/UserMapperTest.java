package kg.alatoo.midterm.mappers;

import kg.alatoo.midterm.DTO.UserDTO;
import kg.alatoo.midterm.entity.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest {

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void testToUserDTO() {
        // Given
        User user = new User();
        user.setId(1L);
        user.setName("Test User");

        // When
        UserDTO userDTO = userMapper.toUserDTO(user);

        // Then
        assertThat(userDTO).isNotNull();
        assertThat(userDTO.getId()).isEqualTo(1L);
        assertThat(userDTO.getName()).isEqualTo("Test User");
    }
}