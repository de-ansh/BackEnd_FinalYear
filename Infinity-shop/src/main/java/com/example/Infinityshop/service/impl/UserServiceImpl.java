package com.example.Infinityshop.service.impl;

import com.example.Infinityshop.Entity.User;
import com.example.Infinityshop.exception.ResourceNotFoundException;
import com.example.Infinityshop.payload.UserDto;
import com.example.Infinityshop.repo.UserRepo;
import com.example.Infinityshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;


    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {


        try {


                User user = this.modelMapper.map(userDto, User.class);
                user.setPassword(passwordEncoder.encode(user.getPassword()));


                System.out.println(passwordEncoder.matches(user.getPassword(), passwordEncoder.encode(user.getPassword())));
                User createdUser = this.userRepo.save(user);
                return this.modelMapper.map(createdUser, UserDto.class);





        } catch (Exception e) {
            throw new UsernameNotFoundException("User with : " + userDto.getEmailId() + " Already exist");
        }

    }





    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User", userId));
        user.setName(userDto.getName());
        user.setEmailId(userDto.getEmailId());
        user.setAddress(userDto.getAddress());
        user.setPassword(userDto.getPassword());
        user.setMobile_no(userDto.getMobileNumber());
        User updatedUser= this.userRepo.save(user);

        return this.modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public UserDto getUserBYiD(Integer userId) {
        User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User", userId));
        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto loadUserByUsername(String emailId) {
        UserDetails user= (UserDetails) this.userRepo.findByEmailId(emailId);
        return this.modelMapper.map(user, UserDto.class);

    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> userList= this.userRepo.findAll();
        List<UserDto> userDtoList= userList.stream().map((user)-> this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "User_ id", userId));
        this.userRepo.delete(user);
    }
}
