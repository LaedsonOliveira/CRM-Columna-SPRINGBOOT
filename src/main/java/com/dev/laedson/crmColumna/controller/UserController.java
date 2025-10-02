package com.dev.laedson.crmColumna.controller;


import com.dev.laedson.crmColumna.dto.CreateUserDto;
import com.dev.laedson.crmColumna.dto.DeleteUserDto;
import com.dev.laedson.crmColumna.dto.GetUserDto;
import com.dev.laedson.crmColumna.dto.PutUserDto;
import com.dev.laedson.crmColumna.model.User;
import com.dev.laedson.crmColumna.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        var userId = userService.createUser(createUserDto);

        return ResponseEntity.created(URI.create("/home" + userId)).body(null);
    }

    @GetMapping
    public User getUserById(@RequestBody GetUserDto getUserDto) {

        return userService.getUserById(getUserDto);

    }

    @PutMapping
    public ResponseEntity<Void> putUser(@RequestBody PutUserDto putUserDto){
        userService.putUser(putUserDto.userId(), putUserDto.telefone());

        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestBody DeleteUserDto deleteUserDto) {
        userService.deleteUser(deleteUserDto.userId());
        return ResponseEntity.ok(null);
    }
}
