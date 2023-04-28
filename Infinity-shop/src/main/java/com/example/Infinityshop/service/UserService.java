package com.example.Infinityshop.service;

import com.example.Infinityshop.payload.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto UpdateUser(UserDto userDto, Integer userId);

    UserDto getUserBYiD(Integer userId);

    List<UserDto> getAllUser();

    void deleteUser( Integer userId);
}
