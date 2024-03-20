package kg.alatoo.midterm.repositories;

import kg.alatoo.midterm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
