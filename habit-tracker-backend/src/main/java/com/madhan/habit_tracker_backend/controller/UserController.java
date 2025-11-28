package com.madhan.habit_tracker_backend.controller;

import com.madhan.habit_tracker_backend.dto.UserRequestDTO;
import com.madhan.habit_tracker_backend.dto.UserResponseDTO;
import com.madhan.habit_tracker_backend.model.User;
import com.madhan.habit_tracker_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE USER
    @PostMapping
    public UserResponseDTO createUser(@RequestBody @Valid UserRequestDTO request) {
        return userService.createUser(request);
    }


    // GET ALL USERS
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
