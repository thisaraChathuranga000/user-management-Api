package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="api/v1/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public List<UserDto> getUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public UserDto getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/addUser")
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @PutMapping("/updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

//    @DeleteMapping("/deleteUser")
//    public String deleteUser(@RequestBody UserDto userDto) {
//        return userService.deleteUser(userDto);
//    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable Integer userId) {
        return userService.deleteUser(userId);
    }


}