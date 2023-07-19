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
}
