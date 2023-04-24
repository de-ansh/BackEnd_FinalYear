package com.Infinitystop.Infinity.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;
    @Column(name = "user_name", nullable = false, length =100 )
    private  String name;
    @Column(name = "user_email", nullable = false, length =100 )
    private String email;
    @Column(name = "user_phone_no", nullable = false, length =10 )
    private Integer  phone_no;
    @Column(name = "password", nullable = false, length =100 )
    private String password;
    @Column(name = "addres", nullable = false, length =200 )
    private String address;



}
