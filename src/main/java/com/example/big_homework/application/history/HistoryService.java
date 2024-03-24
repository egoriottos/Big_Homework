package com.example.big_homework.application.history;

import com.example.big_homework.application.user.UserService;
import com.example.big_homework.domain.entity.History;
import com.example.big_homework.domain.entity.Product;
import com.example.big_homework.domain.entity.User;
import com.example.big_homework.infrastructure.repository.HistoryRepository;
import com.example.big_homework.presentation.history.dto.commands.UpdateHistoryCommands;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final UserService userService;
    private final HistoryRepository historyRepository;

    public List<History> getAll(){
        return historyRepository.findAll();
    }
    public History getById(Integer id){
        return historyRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void delete(Integer id, UpdateHistoryCommands updateHistoryCommands) {
        updateHistoryCommands.getBaseClass().setDeletedAt(LocalDateTime.now());
        historyRepository.deleteById(id);
    }

    public History getByUserId(Integer userId) {
        User user = userService.getById(userId);
        return historyRepository.findByOwner(user);
    }
}

