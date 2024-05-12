package kg.alatoo.midterm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private String username;

    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Roles> roles;

    @OneToMany(mappedBy = "user")
    private Set<Task> tasks;
}