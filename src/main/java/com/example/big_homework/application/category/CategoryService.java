package com.example.big_homework.application.category;

import com.example.big_homework.application.product.ProductService;
import com.example.big_homework.domain.entity.Category;
import com.example.big_homework.domain.entity.Product;
import com.example.big_homework.infrastructure.repository.CategoryRepository;
import com.example.big_homework.presentation.category.dto.commands.CreateCategoryCommands;
import com.example.big_homework.presentation.category.dto.commands.UpdateCategoryCommands;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category getById(Integer id){
        return categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Category update(Integer id, Category categoryFromCommand, UpdateCategoryCommands commands) {
        var category = getById(id);

        if (!category.getTitle().equals(category.getTitle())) category.setTitle(categoryFromCommand.getTitle());

        Category saved = categoryRepository.save(category);
        commands.setUpdatedAt(LocalDateTime.now());

        return saved;
    }

    public Category create(Category categoryFromCommand) {
        Category category = categoryRepository.save(categoryFromCommand);

        return category;
    }

    public void delete(Integer id, UpdateCategoryCommands updateCategoryCommands) {
        updateCategoryCommands.setDeletedAt(LocalDateTime.now());
        categoryRepository.deleteById(id);
    }
}
