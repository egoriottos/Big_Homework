package com.example.big_homework.infrastructure.repository;

import com.example.big_homework.domain.entity.History;
import com.example.big_homework.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {
    History findByOwner(User owner);
}
