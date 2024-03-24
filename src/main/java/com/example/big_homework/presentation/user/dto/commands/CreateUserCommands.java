package com.example.big_homework.presentation.user.dto.commands;

import com.example.big_homework.domain.valueObj.BaseClass;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreateUserCommands {
    private Integer userId;
    private String name;
    private BaseClass baseClass;
}
