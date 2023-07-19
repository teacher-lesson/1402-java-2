package com.example.dto.user;

import com.example.domain.user.User;
import com.example.dto.IDomainDto;
import lombok.Data;

import java.util.HashSet;

@Data
public class UserFullDto implements IDomainDto<Integer> {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int age;

    public UserFullDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.age = user.getAge();
    }

    @Override
    public User toEntity() {
        return new User(id, username, password, firstName, lastName, age, new HashSet<>());
    }

}