package com.example.SpringBootL.repository;

import com.example.SpringBootL.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
