package com.example.big_homework.presentation.trash;

import com.example.big_homework.application.trash.TrashService;
import com.example.big_homework.domain.entity.Trash;
import com.example.big_homework.presentation.trash.dto.commands.CreateTrashCommands;
import com.example.big_homework.presentation.trash.dto.commands.UpdateTrashCommands;
import com.example.big_homework.presentation.trash.dto.queries.TrashQuery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trash")
@AllArgsConstructor
public class TrashController {
    private TrashService service;
    private ModelMapper modelMapper;

    @GetMapping
    public List<TrashQuery> getAll() {
        return service.getAll().stream()
                .map(trash -> modelMapper.map(trash, TrashQuery.class))
                .toList();
    }

    @GetMapping("/{id}")
    public TrashQuery getById(@PathVariable Integer id) {
        return modelMapper.map(service.getById(id), TrashQuery.class);
    }

    @PostMapping
    public TrashQuery create(@RequestBody CreateTrashCommands command) {
        Trash trash = service.create(command);
        if (trash == null) {
            throw new RuntimeException("Произошла ошибка при создании корзины");
        }

        return modelMapper.map(trash, TrashQuery.class);
    }
    @PutMapping("/{id}")
    public TrashQuery update(@PathVariable Integer id, @RequestBody UpdateTrashCommands command) {
        Trash updatedTrash = service.update(id, command);
        return modelMapper.map(updatedTrash, TrashQuery.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id,CreateTrashCommands commands) {
        service.delete(id,commands);
    }
}
