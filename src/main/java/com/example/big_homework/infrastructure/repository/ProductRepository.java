package com.example.big_homework.infrastructure.repository;

import com.example.big_homework.domain.entity.Category;
import com.example.big_homework.domain.entity.Product;
import com.example.big_homework.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByOwner(User owner);

    List<Product> findByCategory(Category category);

    List<Product> findByOwner_NameAllIgnoreCase(String title);

}
