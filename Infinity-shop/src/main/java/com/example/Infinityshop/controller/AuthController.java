package com.example.Infinityshop.controller;


import com.example.Infinityshop.payload.LoginDto;
import com.example.Infinityshop.payload.UserDto;
import com.example.Infinityshop.service.UserService;
import com.example.Infinityshop.security.JwtUtil;
import com.example.Infinityshop.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/public")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;



    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;


    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();




    @PostMapping("/signup")
    public String signUp(@RequestBody UserDto userDto) {

        userService.createUser(userDto);
        return "User created successfully";
    }



    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        System.out.println(email);
        System.out.println(password);

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        System.out.println(userDetails.getPassword());

        // Compare raw password with encoded password from the database
        if (passwordEncoder.matches(password, userDetails.getPassword()) &&
                email.equals(userDetails.getUsername())) {

            String jwt = jwtUtil.generateToken(userDetails.getUsername());
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        }

        System.out.print("Exception occurred while createAuthenticationToken ");
        return new ResponseEntity<>("Incorrect username or password", HttpStatus.BAD_REQUEST);
    }

}
