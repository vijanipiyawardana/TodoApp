package com.vijani.TODOApp.controller;

import com.vijani.TODOApp.entity.TodoItem;
import com.vijani.TODOApp.service.TodoItemService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoItemController {

    private final TodoItemService todoItemService;

    @PostMapping("/save")
    public ResponseEntity<String>  todoSave(@RequestBody TodoItem todoItem){
        String output = todoItemService.todoSave(todoItem);
        ResponseEntity<String> response = ResponseEntity.accepted().body(output);
        return response;
    }

    @GetMapping("/get")
    public ResponseEntity<List<TodoItem>> todoGet(){
        List<TodoItem> todoItems = todoItemService.todoGetAll();
        ResponseEntity<List<TodoItem>> response = ResponseEntity.ok(todoItems);
        return response;
    }

}
