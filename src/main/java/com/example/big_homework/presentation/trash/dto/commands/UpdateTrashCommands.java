package com.example.big_homework.presentation.trash.dto.commands;

import com.example.big_homework.domain.entity.Product;
import com.example.big_homework.domain.valueObj.BaseClass;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class UpdateTrashCommands {
    private Integer trashId;
    private List<Product> products;
    private BaseClass baseClass;
}
