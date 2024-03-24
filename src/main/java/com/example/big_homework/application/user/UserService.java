package com.example.big_homework.application.user;

import com.example.big_homework.domain.entity.User;
import com.example.big_homework.infrastructure.repository.UserRepository;
import com.example.big_homework.presentation.user.dto.commands.UpdateUserCommands;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public User create(User userFromCommand) {
        User user = repository.save(userFromCommand);

        return user;
    }

    public User update(Integer id, User userFromCommand, UpdateUserCommands commands) {
        var user = getById(id);

        if (!user.getName().equals(userFromCommand.getName())) user.setName(userFromCommand.getName());

        User saved = repository.save(user);
        commands.getBaseClass().setUpdatedAt(LocalDateTime.now());

        return saved;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
