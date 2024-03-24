package com.example.big_homework.presentation.product.dto.commands;

import com.example.big_homework.domain.valueObj.BaseClass;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class CreateProductCommands {
    private String title;
    private Integer price;
    private Integer productId;
    private BaseClass baseClass;
}
