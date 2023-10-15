package com.vijani.TODOApp.service;

import com.vijani.TODOApp.dto.TodoItemRequestDto;
import com.vijani.TODOApp.dto.TodoItemResponseDto;
import com.vijani.TODOApp.entity.TodoItem;
import com.vijani.TODOApp.repository.TodoItemRepository;
import com.vijani.TODOApp.util.Converter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoItemService {

    private final TodoItemRepository todoItemRepository;

    public TodoItemResponseDto todoSave(TodoItemRequestDto dto){
        TodoItem todoItem = Converter.fromTodoItemRequestDto(dto);
        todoItemRepository.save(todoItem);
        return Converter.toTodoItemResponseDto(todoItem);
    }

    public List<TodoItemResponseDto> todoGetAll(){
        List<TodoItem> todoItemList = todoItemRepository.findAll();
        return Converter.toTodoItemResponseDtoList(todoItemList);
    }
}
