package com.example.dto.user;

import com.example.domain.user.User;
import com.example.dto.IDomainDto;
import com.example.dto.book.BookDto;
import com.example.dto.role.RoleDto;
import lombok.Data;

import java.util.Collection;
import java.util.HashSet;

@Data
public class UserFullDto implements IDomainDto<Integer> {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private Collection<BookDto> books;
    private Collection<RoleDto> roles;


}
