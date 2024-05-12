    package kg.alatoo.midterm.service;

    import kg.alatoo.midterm.DTO.UserDTO;
    import kg.alatoo.midterm.DTO.authorization.RegistrationDTO;
    import kg.alatoo.midterm.entity.Roles;
    import kg.alatoo.midterm.entity.User;
    import kg.alatoo.midterm.mappers.UserMapper;
    import kg.alatoo.midterm.repositories.UserRepository;
    import kg.alatoo.midterm.repositories.UserRolesRepository;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Set;
    import java.util.stream.Collectors;

    @Service
    public class UserService {

        private final UserRepository userRepository;
        private final UserMapper userMapper;
        private final PasswordEncoder passwordEncoder;
        private final UserRolesRepository userRolesRepository;

        public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, UserRolesRepository userRolesRepository) {
            this.userRepository = userRepository;
            this.userMapper = userMapper;
            this.passwordEncoder = passwordEncoder;
            this.userRolesRepository = userRolesRepository;
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

        public UserDTO register(RegistrationDTO registrationDTO) {
            Roles roles = userRolesRepository.findByRoleName(Roles.Name.USER)
                    .orElseThrow(() -> new RuntimeException("USER role not found")); // Handle if the role doesn't exist
            User user = User.builder()
                    .name(registrationDTO.getName())
                    .username(registrationDTO.getUsername())
                    .password(passwordEncoder.encode(registrationDTO.getPassword()))
                    .roles(Set.of(roles))
                    .build();
            User savedUser = userRepository.save(user);
            return userMapper.userToUserDTO(savedUser);
        }
    }