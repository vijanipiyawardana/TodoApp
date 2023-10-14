package com.vijani.TODOApp.repository;

import com.vijani.TODOApp.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
