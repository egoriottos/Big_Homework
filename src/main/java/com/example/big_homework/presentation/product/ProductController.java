package com.example.big_homework.presentation.product;

import com.example.big_homework.application.product.ProductService;
import com.example.big_homework.domain.entity.Category;
import com.example.big_homework.domain.entity.Product;
import com.example.big_homework.presentation.product.dto.commands.CreateProductCommands;
import com.example.big_homework.presentation.product.dto.commands.UpdateProductCommands;
import com.example.big_homework.presentation.product.dto.queries.ProductQuery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<ProductQuery> getAll(){
        return productService.getAll()
                .stream()
                .map(element->modelMapper.map(element,ProductQuery.class)).toList();
    }
    @GetMapping("{id}")
    public ProductQuery getById(@PathVariable Integer id){
        if(id == null){
            throw new IllegalArgumentException("Пустой параметр запроса " + null);
        }
        Product productId = productService.getById(id);
        if(productId == null){
            throw new IllegalArgumentException("Такого продукта нет в базе " + null);
        }
        return modelMapper.map(productId, ProductQuery.class);
    }

    @GetMapping("user/{userId}")
    public List<ProductQuery> getByUserId(@PathVariable Integer userId){
        return productService.getByUserId(userId)
                .stream()
                .map(product -> modelMapper.map(product, ProductQuery.class))
                .toList();
    }

    @GetMapping("category/{category}")
    public List<ProductQuery>getByCategory(@PathVariable Category category){
        return productService.getByCategory(category)
                .stream()
                .map(product -> modelMapper.map(product,ProductQuery.class))
                .toList();
    }

    @GetMapping("user-name/{name}")
    public List<ProductQuery>getByUserName(@PathVariable String name){
        return productService.getByUserName(name)
                .stream()
                .map(product -> modelMapper.map(product, ProductQuery.class))
                .toList();
    }

    @PostMapping
    public ProductQuery createProduct(@RequestBody CreateProductCommands createProductCommands){
        Product product = productService.create(createProductCommands);
        if(product == null){
            throw new RuntimeException("Продукт равен null " + null);
        }
        return modelMapper.map(product, ProductQuery.class);
    }
    @PutMapping("{id}")
    public ProductQuery changeProduct(@PathVariable Integer id, @RequestBody UpdateProductCommands updateProductCommands){
        Product updateProduct = productService.update(id, updateProductCommands);
        return modelMapper.map(updateProduct, ProductQuery.class);
    }
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Integer id,UpdateProductCommands commands){
         productService.delete(id,commands);
    }
}
