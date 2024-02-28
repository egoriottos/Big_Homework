package com.example.big_homework.application.trash;

import com.example.big_homework.application.product.ProductService;
import com.example.big_homework.application.user.UserService;
import com.example.big_homework.domain.entity.Product;
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
    private final ProductService productService;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    private final Set<Product> products = new HashSet<>();

    public List<Trash> getAll() {
        return repository.findAll();
    }

    public Trash getById(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Trash create(CreateTrashCommands createTrashCommand) {
        User byId = userService.getById(createTrashCommand.getUserId());
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
        User byId = userService.getById(updateTrashCommand.getUserId());

        if (updateTrashCommand.getUserId() != null && !updateTrashCommand.getUserId().equals(foundTrash.getUser())) {
            foundTrash.setId(updateTrashCommand.getUserId());
        }
        if (updateTrashCommand.getCreatedAt() != null && !updateTrashCommand.getCreatedAt().equals(foundTrash.getCreatedAt())) {
            foundTrash.setCreatedAt(updateTrashCommand.getCreatedAt());
        }

        Trash savedTrash = repository.save(foundTrash);
        updateTrashCommand.setUpdatedAt(LocalDateTime.now());
        return savedTrash;
    }

    public void delete(Integer id,CreateTrashCommands createTrashCommands) {
        createTrashCommands.setDeletedAt(LocalDateTime.now());
        repository.deleteById(id);

    }

    public List<Product> getByOwnerId(Integer ownerId) {
        User user = userService.getById(ownerId);

        return productRepository.findByUser(user);
    }

    public List<Product> getByOwnerName(String ownerName) {
        return productRepository.findByUser_NameAllIgnoreCase(ownerName);
    }

}
