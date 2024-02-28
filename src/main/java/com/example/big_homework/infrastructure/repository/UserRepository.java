package com.example.big_homework.infrastructure.repository;

import com.example.big_homework.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
