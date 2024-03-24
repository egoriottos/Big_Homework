package com.example.big_homework.presentation.category.dto.commands;

import com.example.big_homework.domain.valueObj.BaseClass;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class CreateCategoryCommands {
    private String title;
    private Integer category_id;
    private BaseClass baseClass;

}
