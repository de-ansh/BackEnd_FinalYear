package com.example.Infinityshop.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Integer userId;
    private  String name;
    private  String emailId;
    private String password;
    private String address;
    private String mobile_no;

}
