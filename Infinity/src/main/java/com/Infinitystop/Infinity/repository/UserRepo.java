package com.Infinitystop.Infinity.repository;

import com.Infinitystop.Infinity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
