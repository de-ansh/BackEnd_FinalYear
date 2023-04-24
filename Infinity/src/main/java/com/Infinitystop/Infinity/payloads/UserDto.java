package com.Infinitystop.Infinity.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long userid;
    private String name;
    private String email;
    private Integer phone;
    private  String password;
    private String address;

}
