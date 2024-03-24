package com.example.big_homework.presentation.category.dto.commands;

import com.example.big_homework.domain.valueObj.BaseClass;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UpdateCategoryCommands {
    private String title;
    private Integer category_id;
    private BaseClass baseClass;
}
