package kg.alatoo.midterm.repositories;

import kg.alatoo.midterm.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<Roles, Roles.Name>,
        JpaRepository<Roles, Roles.Name> {
}