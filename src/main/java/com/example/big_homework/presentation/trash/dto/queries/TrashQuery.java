package com.example.big_homework.presentation.trash.dto.queries;

import com.example.big_homework.presentation.category.dto.queries.CategoryQuery;
import com.example.big_homework.presentation.product.dto.queries.ProductQuery;
import com.example.big_homework.presentation.user.dto.queries.UserQuery;
import lombok.Data;

@Data
public class TrashQuery {
    private Integer id;
    private ProductQuery query;
    private UserQuery owner;
}
