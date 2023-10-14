package com.vijani.TODOApp.util;

import com.vijani.TODOApp.dto.TodoItemRequestDto;
import com.vijani.TODOApp.dto.TodoItemResponseDto;
import com.vijani.TODOApp.entity.TodoItem;

import java.util.List;

public class Converter {

    public static TodoItem fromTodoItemRequestDto(TodoItemRequestDto dto) {
        return TodoItem.createTodoWithDefaults(dto.title());
    }

    public static TodoItemResponseDto toTodoItemResponseDto(TodoItem item) {
        return new TodoItemResponseDto(
                item.getId(),
                item.getTitle(),
                item.getAddedDate(),
                item.getStatus()
        );
    }

    public static List<TodoItemResponseDto> toTodoItemResponseDtoList(List<TodoItem> items) {
        List<TodoItemResponseDto> todoItemResponses = items.stream().map(item -> toTodoItemResponseDto(item)).toList();
        return todoItemResponses;
    }
}
