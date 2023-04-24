package com.Infinitystop.Infinity.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long user_id;
    private String name;
    private String email;
    private String phone;
    private  String password;
    private String address;

}
