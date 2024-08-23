package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDto> getAllUsers() {
        List<User>userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDto>>(){}.getType());
    }

    public UserDto saveUser(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
        return userDto;
    }

    public UserDto updateUser(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
        return userDto;
    }

//    public String deleteUser(UserDto userDto) {
//        userRepo.delete(modelMapper.map(userDto, User.class));
//        return "User deleted";
//    }

    public String deleteUser(Integer userId) {
        userRepo.deleteById(userId);
        return "User deleted";
    }

    public UserDto getUserById(Integer userId) {
        User user = userRepo.getUserById(userId);
        return modelMapper.map(user, UserDto.class);
    }
}
