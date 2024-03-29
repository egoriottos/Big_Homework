package com.example.big_homework.application.product;

import com.example.big_homework.application.category.CategoryService;
import com.example.big_homework.application.user.UserService;
import com.example.big_homework.domain.entity.Category;
import com.example.big_homework.domain.entity.Product;
import com.example.big_homework.domain.entity.User;
import com.example.big_homework.infrastructure.repository.ProductRepository;
import com.example.big_homework.presentation.product.dto.commands.CreateProductCommands;
import com.example.big_homework.presentation.product.dto.commands.UpdateProductCommands;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final ProductRepository productRepository;


    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Integer id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Product> getByUserId(Integer userId) {
        User user = userService.getById(userId);
        return productRepository.findByOwner(user);
    }

    public List<Product> getByUserName(String name) {
        return productRepository.findByOwner_NameAllIgnoreCase(name);
    }

    public List<Product> getByCategory(Category category) {

        //todo: реши проблему
        return productRepository.findByCategory(category);
    }

    public Product create(CreateProductCommands createProductCommands) {
        User userId = userService.getById(createProductCommands.getProductId());
        if (userId == null) {
            return null;
        }
        Product product = modelMapper.map(createProductCommands, Product.class);
        product.setOwner(userId);
        productRepository.save(product);
        return product;
    }

    public Product update(Integer id, UpdateProductCommands productFromCommand) {
        var product = getById(id);

        if (!product.getTitle().equals(productFromCommand.getTitle())
                && !productFromCommand.getBaseClass().getCreatedAt().equals(product.getBaseClass().getCreatedAt())) {
            product.setTitle(productFromCommand.getTitle());
            product.getBaseClass().setCreatedAt(productFromCommand.getBaseClass().getCreatedAt());
        }

        Product saved = productRepository.save(product);
        product.getBaseClass().setUpdatedAt(LocalDateTime.now());

        return saved;
    }

    public void delete(Integer id, UpdateProductCommands commands) {
        commands.getBaseClass().setDeletedAt(LocalDateTime.now());
        productRepository.deleteById(id);

    }
}
