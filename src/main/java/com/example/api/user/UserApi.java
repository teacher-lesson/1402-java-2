package com.example.api.user;

import com.example.dto.user.UserDto;
import com.example.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/user")
public class UserApi {
    private final UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping(value = "/test")
//    public String test() {
//        userService.create(new UserDto(new User("admin1", "pass1", "Ali1", "Alavi1", 21)));
//        userService.create(new UserDto(new User("admin2", "pass2", "Ali2", "Alavi2", 22)));
//        userService.create(new UserDto(new User("admin3", "pass3", "Ali3", "Alavi3", 23)));
//        userService.create(new UserDto(new User("admin4", "pass4", "Ali4", "Alavi4", 24)));
//        userService.create(new UserDto(new User("admin5", "pass5", "Ali5", "Alavi5", 25)));
//
//        return "OK";
//    }

    @PostMapping(value = "/", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody UserDto dto) {
        userService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
//        return ResponseEntity.status(201).build();
    }

    @GetMapping(value = "/list", produces = APPLICATION_JSON_VALUE)
    public List<UserDto> readAll() {
        final List<UserDto> userDtos = userService.readAll();

        return userDtos;
    }

    @GetMapping(value = "/", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity readById(@RequestParam Integer id) {
        final UserDto read = userService.read(id);

        if (read == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(read);
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity readByIdByPath(@PathVariable Integer id) {
        return readById(id);
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestBody UserDto dto) {
        if (dto.getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        final UserDto read = userService.read(dto.getId());

        if (read == null) {
            return ResponseEntity.notFound().build();
        }

        userService.update(dto);

        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable Integer id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        userService.delete(id);

        return ResponseEntity.accepted().build();
    }


}
