package com.example.big_homework.presentation.history.dto.commands;

import com.example.big_homework.domain.entity.Product;
import com.example.big_homework.domain.valueObj.BaseClass;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CreateHistoryCommands {
    private Integer historyId;
    private List<Product> products;
    private BaseClass baseClass;
}
