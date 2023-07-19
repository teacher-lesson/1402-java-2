package com.example.api.user;

import com.example.dto.user.UserDto;
import com.example.dto.user.UserFullDto;
import com.example.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/users")
public class UserApi {
    private final UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody UserDto dto) {
        userService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
//        return ResponseEntity.status(201).build();
    }

    @GetMapping(value = "/", produces = APPLICATION_JSON_VALUE)
    public List<UserDto> readAll() {
        final List<UserDto> userDtos = userService.readAll();

        return userDtos;
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity readByIdByPath(@PathVariable Integer id) {
        final UserDto read = userService.read(id);
        return ResponseEntity.ok(read);
    }

    @GetMapping(value = "/full/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity readFullByIdByPath(@PathVariable Integer id) {
        final UserFullDto fullDto = userService.readFullById(id);
        return ResponseEntity.ok(fullDto);
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestBody UserDto dto) {
        userService.update(dto);

        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable Integer id) {
        userService.delete(id);

        return ResponseEntity.accepted().build();
    }


}
