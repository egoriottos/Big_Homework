package com.example.big_homework.presentation.user;

import com.example.big_homework.application.user.UserService;
import com.example.big_homework.domain.entity.User;
import com.example.big_homework.presentation.user.dto.commands.CreateUserCommands;
import com.example.big_homework.presentation.user.dto.commands.UpdateUserCommands;
import com.example.big_homework.presentation.user.dto.queries.UserQuery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService service;
    private ModelMapper modelMapper;


    @GetMapping
    public List<UserQuery> getAll() {
        return service.getAll().stream()
                .map(user -> modelMapper.map(user, UserQuery.class))
                .toList();
    }

    @GetMapping("/{id}")
    public UserQuery getById(@PathVariable Integer id) {
        return modelMapper.map(service.getById(id), UserQuery.class);
    }

    @PostMapping
    public UserQuery create(@RequestBody CreateUserCommands command) {
        User userFromCommand = modelMapper.map(command, User.class);

        User user = service.create(userFromCommand);

        UserQuery userQueryResponse = modelMapper.map(user, UserQuery.class);

        return userQueryResponse;
    }
    @PutMapping("/{id}")
    public UserQuery update(@PathVariable Integer id, @RequestBody UpdateUserCommands command) {
        User userFromCommand = modelMapper.map(command, User.class);

        User user = service.update(id, userFromCommand,command);

        UserQuery userQueryResponse = modelMapper.map(user, UserQuery.class);

        return userQueryResponse;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id,@RequestBody UpdateUserCommands commands) {
        commands.getBaseClass().setDeletedAt(LocalDateTime.now());
        service.delete(id);
    }

}
