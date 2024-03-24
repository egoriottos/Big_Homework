package com.example.big_homework.presentation.history;

import com.example.big_homework.application.history.HistoryService;
import com.example.big_homework.domain.entity.History;
import com.example.big_homework.presentation.history.dto.commands.UpdateHistoryCommands;
import com.example.big_homework.presentation.history.dto.queries.HistoryQuery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/history")
@AllArgsConstructor
public class HistoryController {
    private final HistoryService service;
    private final ModelMapper mapper;

    @GetMapping
    public List<HistoryQuery> getAll(){
        return service.getAll()
                .stream()
                .map(element->mapper.map(element,HistoryQuery.class)).toList();
    }

    @GetMapping("{id}")
    public HistoryQuery getById(@PathVariable Integer id){
        if(id == null){
            throw new IllegalArgumentException("Пустой параметр запроса " + null);
        }
        History historyId = service.getById(id);
        if(historyId == null){
            throw new IllegalArgumentException("Такой истории нет в базе " + null);
        }
        return mapper.map(historyId, HistoryQuery.class);
    }

    @GetMapping("user/{userId}")
    public HistoryQuery getByUserId(@PathVariable Integer userId){
        return mapper.map(service.getByUserId(userId),HistoryQuery.class);

    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id, UpdateHistoryCommands commands) {
        service.delete(id,commands);
        LocalDateTime localDateTime = LocalDateTime.now();
    }
}
