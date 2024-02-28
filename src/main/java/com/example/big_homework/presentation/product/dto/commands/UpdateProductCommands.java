package com.example.big_homework.presentation.product.dto.commands;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@Builder
public class UpdateProductCommands {
    private String title;
    private Integer price;
    private Integer userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
