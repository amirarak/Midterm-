    package kg.alatoo.midterm.service;

    import kg.alatoo.midterm.DTO.UserDTO;
    import kg.alatoo.midterm.entity.User;
    import kg.alatoo.midterm.mappers.UserMapper;
    import kg.alatoo.midterm.repositories.UserRepository;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.stream.Collectors;

    @Service
    public class UserService {

        private final UserRepository userRepository;
        private final UserMapper userMapper;

        public UserService(UserRepository userRepository, UserMapper userMapper) {
            this.userRepository = userRepository;
            this.userMapper = userMapper;
        }

        public List<UserDTO> getAllUsers() {
            List<User> users = userRepository.findAll();
            return users.stream()
                    .map(userMapper::userToUserDTO)
                    .collect(Collectors.toList());
        }


        public User getUserById(Long id) {
            return userRepository.findById(id).orElse(null);
        }

        public User saveUser(User user) {
            return userRepository.save(user);
        }

        public void deleteUserById(Long id) {
            userRepository.deleteById(id);
        }
    }