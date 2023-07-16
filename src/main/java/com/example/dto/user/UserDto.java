package com.example.dto.user;

import com.example.domain.user.User;
import com.example.dto.IDto;
import com.example.dto.book.BookDto;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserDto implements IDto<Integer> {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private Set<BookDto> books = new HashSet<>();

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.age = user.getAge();
        this.books = user.getBooks().stream().map(BookDto::new).collect(Collectors.toSet());
    }

    @Override
    public User toEntity() {
        return new User(id, username, password, firstName, lastName, age, books.stream().map(BookDto::toEntity).collect(Collectors.toSet()));
    }
}
