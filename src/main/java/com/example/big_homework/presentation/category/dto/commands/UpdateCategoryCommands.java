package com.example.big_homework.presentation.category.dto.commands;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UpdateCategoryCommands {
    private String title;
    private Integer userId;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public LocalDateTime deletedAt;
}
