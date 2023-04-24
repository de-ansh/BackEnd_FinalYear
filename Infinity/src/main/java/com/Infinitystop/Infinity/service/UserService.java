package com.Infinitystop.Infinity.service;

import com.Infinitystop.Infinity.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserBYiD(Integer userId);

    List<UserDto> getAllUser();

    void deleteUser( Integer userId);
}
