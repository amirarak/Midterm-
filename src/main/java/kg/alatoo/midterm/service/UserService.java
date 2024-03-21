    package kg.alatoo.midterm.service;

    import kg.alatoo.midterm.entity.User;
    import kg.alatoo.midterm.repositories.UserRepository;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class UserService {

        private final UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public List<User> getAllUsers() {
            return userRepository.findAll();
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