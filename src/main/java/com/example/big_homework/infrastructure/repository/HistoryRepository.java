package com.example.big_homework.infrastructure.repository;

import com.example.big_homework.domain.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History,Integer> {
}
