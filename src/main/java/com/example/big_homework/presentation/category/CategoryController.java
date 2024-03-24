package com.example.big_homework.presentation.category;

import com.example.big_homework.application.category.CategoryService;
import com.example.big_homework.domain.entity.Category;
import com.example.big_homework.presentation.category.dto.commands.CreateCategoryCommands;
import com.example.big_homework.presentation.category.dto.commands.UpdateCategoryCommands;
import com.example.big_homework.presentation.category.dto.queries.CategoryQuery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<CategoryQuery> getAll() {
        return service.getAll().stream()
                .map(category -> modelMapper.map(category, CategoryQuery.class))
                .toList();
    }

    @GetMapping("/{id}")
    public CategoryQuery getById(@PathVariable Integer id) {
        return modelMapper.map(service.getById(id), CategoryQuery.class);
    }

    @PostMapping
    public CategoryQuery create(@RequestBody CreateCategoryCommands command) {
        Category categoryFromCommand = modelMapper.map(command, Category.class);

        Category category = service.create(categoryFromCommand);

       CategoryQuery categoryQueryResponse = modelMapper.map(category, CategoryQuery.class);

        return categoryQueryResponse;
    }
    @PutMapping("/{id}")
    public CategoryQuery update(@PathVariable Integer id, @RequestBody UpdateCategoryCommands command) {
       Category categoryFromCommand = modelMapper.map(command, Category.class);

        Category category = service.update(id, categoryFromCommand,command);

        CategoryQuery categoryQueryResponse = modelMapper.map(category, CategoryQuery.class);

        return categoryQueryResponse;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id, @RequestBody UpdateCategoryCommands commands) {
        service.delete(id,commands);
    }
}
