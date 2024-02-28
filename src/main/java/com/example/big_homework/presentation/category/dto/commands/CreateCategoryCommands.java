package com.example.big_homework.presentation.category.dto.commands;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class CreateCategoryCommands {
    private String title;
    private Integer userId;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public LocalDateTime deletedAt;

}
