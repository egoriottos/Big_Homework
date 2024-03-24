package com.example.big_homework.presentation.product.dto.queries;

import com.example.big_homework.presentation.category.dto.queries.CategoryQuery;
import com.example.big_homework.presentation.user.dto.queries.UserQuery;
import lombok.Data;

@Data
public class ProductQuery {
    private Integer id;
    private Integer price;
    private String title;
    private CategoryQuery categoryQuery;
}
