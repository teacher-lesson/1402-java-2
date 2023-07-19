package com.example.dto.user;

import com.example.domain.user.User;
import com.example.dto.IDomainDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;

@Data
@NoArgsConstructor
public class UserDto implements IDomainDto<Integer> {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int age;

    public UserDto(User user) {
        if (user != null) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.password = user.getPassword();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.age = user.getAge();
        }
    }

    @Override
    public User toEntity() {
        return new User(id, username, password, firstName, lastName, age, Collections.emptySet());
    }
}
