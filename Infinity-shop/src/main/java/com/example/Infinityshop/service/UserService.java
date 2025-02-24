package com.example.Infinityshop.service;

import com.example.Infinityshop.payload.UserDto;
import  com.example.Infinityshop.payload.LoginDto;

import java.util.List;

public interface UserService {


    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto, Integer userId);

    UserDto getUserBYiD(Integer userId);

    UserDto loadUserByUsername(String emailId);

    List<UserDto> getAllUser();

    void deleteUser( Integer userId);
}
