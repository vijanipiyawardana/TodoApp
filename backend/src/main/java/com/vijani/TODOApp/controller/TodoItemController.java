package com.vijani.TODOApp.controller;

import com.vijani.TODOApp.dto.TodoItemRequestDto;
import com.vijani.TODOApp.dto.TodoItemResponseDto;
import com.vijani.TODOApp.service.TodoItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoItemController {

    private final TodoItemService todoItemService;

    @PostMapping
    public ResponseEntity<String> todoSave(@RequestBody TodoItemRequestDto dto){
        String output = todoItemService.todoSave(dto);
        return ResponseEntity.accepted().body(output);
    }

    @GetMapping
    public ResponseEntity<List<TodoItemResponseDto>> todoGet(){
        List<TodoItemResponseDto> todoItemResponses = todoItemService.todoGetAll();
        return ResponseEntity.ok(todoItemResponses);
    }
}
