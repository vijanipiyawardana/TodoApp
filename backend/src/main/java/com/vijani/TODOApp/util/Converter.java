package com.vijani.TODOApp.util;

import com.vijani.TODOApp.dto.TodoItemRequestDto;
import com.vijani.TODOApp.entity.TodoItem;

public class Converter {

    public static TodoItem fromTodoItemRequestDto(TodoItemRequestDto dto) {
        return TodoItem.createTodoWithDefaults(dto.title());
    }
}
