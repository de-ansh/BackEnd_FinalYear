package com.example.Infinityshop.repo;

import com.example.Infinityshop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
