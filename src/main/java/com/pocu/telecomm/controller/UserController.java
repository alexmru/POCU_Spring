package com.pocu.telecomm.controller;


import com.pocu.telecomm.entity.User;
import com.pocu.telecomm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "all")
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PutMapping(path = "/update/{id}")
    public void putUser(Long id, @RequestBody User user) {
        userService.putUser(id, user);
    }

    @PostMapping(path = "/add")
    public void postUser(@RequestBody User user) {
        userService.postUser(user);
    }

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteParkingLotById(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
