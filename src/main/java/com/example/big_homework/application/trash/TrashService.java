package com.example.big_homework.application.trash;

import com.example.big_homework.application.user.UserService;
import com.example.big_homework.domain.entity.Trash;
import com.example.big_homework.domain.entity.User;
import com.example.big_homework.infrastructure.repository.ProductRepository;
import com.example.big_homework.infrastructure.repository.TrashRepository;
import com.example.big_homework.presentation.trash.dto.commands.CreateTrashCommands;
import com.example.big_homework.presentation.trash.dto.commands.UpdateTrashCommands;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TrashService {
    private final UserService userService;
    private final TrashRepository repository;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    public List<Trash> getAll() {
        return repository.findAll();
    }

    public Trash getById(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Trash create(CreateTrashCommands createTrashCommand) {
        User byId = userService.getById(createTrashCommand.getTrashId());
        if (byId == null) {
            return null;
        }

        Trash newTrash = modelMapper.map(createTrashCommand, Trash.class);
        newTrash.setUser(byId);
        repository.save(newTrash);
        return newTrash;
    }

    public Trash update(Integer id, UpdateTrashCommands updateTrashCommand) {

        Trash foundTrash = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("проблема с поиском корзины в методе обновления"));
        User byId = userService.getById(updateTrashCommand.getTrashId());

        if (updateTrashCommand.getTrashId() != null && !updateTrashCommand.getTrashId().equals(foundTrash.getUser())) {
            foundTrash.setId(updateTrashCommand.getTrashId());
        }
        if (updateTrashCommand.getBaseClass().getCreatedAt() != null && !updateTrashCommand.getBaseClass().getCreatedAt().equals(foundTrash.getBaseClass().getCreatedAt())) {
            foundTrash.getBaseClass().setCreatedAt(updateTrashCommand.getBaseClass().getCreatedAt());
        }

        Trash savedTrash = repository.save(foundTrash);
        updateTrashCommand.getBaseClass().setUpdatedAt(LocalDateTime.now());
        return savedTrash;
    }

    public void delete(Integer id,CreateTrashCommands createTrashCommands) {
        createTrashCommands.getBaseClass().setDeletedAt(LocalDateTime.now());
        repository.deleteById(id);

    }
}
