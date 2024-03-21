package kg.alatoo.midterm.repositories;

import kg.alatoo.midterm.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll() {
        User user1 = User.builder().name("John").build();
        User user2 = User.builder().name("Alice").build();
        userRepository.save(user1);
        userRepository.save(user2);

        List<User> users = userRepository.findAll();

        assertThat(users.size()).isEqualTo(2);
        assertThat(users).contains(user1, user2);
    }

    @Test
    public void testFindById() {
        User user = User.builder().name("John").build();
        User savedUser = userRepository.save(user);

        Optional<User> optionalUser = userRepository.findById(savedUser.getId());

        assertThat(optionalUser).isPresent();
        assertThat(optionalUser.get()).isEqualTo(savedUser);
    }

}