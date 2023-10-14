package com.vijani.TODOApp.dto;

import com.vijani.TODOApp.entity.TodoStatus;

import java.util.Date;

public record TodoItemResponseDto(
        Long id,
        String title,
        Date addedDate,
        TodoStatus status) {
}
