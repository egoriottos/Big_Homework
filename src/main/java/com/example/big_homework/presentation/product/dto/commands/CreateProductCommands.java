package com.example.big_homework.presentation.product.dto.commands;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class CreateProductCommands {
    private String title;
    private Integer price;
    private Integer userId;
    public LocalDateTime createdAt = LocalDateTime.now();
    public LocalDateTime updatedAt;
    public LocalDateTime deletedAt;
}
