package com.example.big_homework.infrastructure.repository;

import com.example.big_homework.domain.entity.Trash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrashRepository extends JpaRepository<Trash,Integer> {
}
