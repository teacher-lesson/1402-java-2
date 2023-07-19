package com.example.domain.user;

import com.example.domain.IEntity;
import com.example.domain.book.Book;
import com.example.domain.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@ToString(exclude = "books")
@EqualsAndHashCode(exclude = "books")
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class User implements IEntity<Integer> {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    private Set<Book> books = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    public User(Integer id, String username, String password, String firstName, String lastName, int age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public User(String username, String password, String firstName, String lastName, int age) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public User(String username, String password, String firstName, String lastName, int age, Set<Book> books) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.books = books;
    }
}
