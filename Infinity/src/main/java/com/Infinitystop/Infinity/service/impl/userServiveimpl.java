package com.Infinitystop.Infinity.service.impl;

import com.Infinitystop.Infinity.entity.User;
import com.Infinitystop.Infinity.payloads.UserDto;
import com.Infinitystop.Infinity.service.UserService;

import java.util.List;

public class userServiveimpl implements UserService {
    @Override
    public UserDto createUser(UserDto user) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto user, Integer userId) {
        return null;
    }

    @Override
    public UserDto getUserBYiD(Integer userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUser() {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }
    private User dtotoUser(UserDto userDto){
        User user= new User();
        user.setUserid(userDto.getUserid());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAddress(userDto.getAddress());
        user.setPhone_no(userDto.getPhone());


        return  user;
    }

    public  UserDto userToDto(User user){
        UserDto userDto= new UserDto();
        userDto.setUserid(user.getUserid());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAddress(user.getAddress());
        userDto.setPhone(user.getPhone_no());

        return userDto;
    }
}
