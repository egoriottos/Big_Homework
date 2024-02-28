package com.example.big_homework.presentation.history.dto.queries;

import com.example.big_homework.presentation.category.dto.queries.CategoryQuery;
import com.example.big_homework.presentation.user.dto.queries.UserQuery;
import lombok.Data;

@Data
public class HistoryQuery {
    private Integer id;
    private UserQuery owner;
    private CategoryQuery categoryQuery;
}
