package com.example.Infinityshop.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name = "name", length = 100, nullable = false)
    private  String name;
    @Column(name = "emailId", length = 100, nullable = false)
    private  String emailId;
    @Column(name = "password", length = 100, nullable = false)
    private String password;
    @Column(name = "address", nullable = true)
    private String address;
    @Column(name = "mobileNumber", length = 10, nullable = true)
    private String mobile_no;


}
