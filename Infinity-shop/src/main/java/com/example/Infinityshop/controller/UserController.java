package com.example.Infinityshop.controller;

import com.example.Infinityshop.payload.UserDto;
import com.example.Infinityshop.response.ApiResponse;
import com.example.Infinityshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createUser= this.userService.createUser(userDto);
        return  new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }
    @PutMapping("/{userId}")
    public  ResponseEntity<UserDto> updateUser( @PathVariable Integer userId, @RequestBody UserDto userDto ){
        UserDto updateuser= this.userService.updateUser( userDto, userId);
        return ResponseEntity.ok(updateuser);

    }
    //delete
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteuser(@PathVariable Integer userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Succesfully", true), HttpStatus.OK);
    }
    //Get
    @GetMapping("/")
    public  ResponseEntity<List<UserDto>> getAllUser(){
        return  ResponseEntity.ok(this.userService.getAllUser());
    }
    //GetByUserId
    @GetMapping("/{userID}")
    public  ResponseEntity<UserDto> getUserById(@PathVariable Integer userID){
        return ResponseEntity.ok(this.userService.getUserBYiD(userID));
    }

}
