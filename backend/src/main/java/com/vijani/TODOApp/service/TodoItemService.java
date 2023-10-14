package com.vijani.TODOApp.service;

import com.vijani.TODOApp.entity.TodoItem;
import com.vijani.TODOApp.repository.TodoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoItemService {

    private final TodoItemRepository todoItemRepository;

    public String todoSave(TodoItem item){
        item.setAddedDate(new Date());
        todoItemRepository.save(item);
        return "Successfully saved!";
    }

    public List<TodoItem> todoGetAll(){
        List<TodoItem> todoItemList = todoItemRepository.findAll();
        return todoItemList;
    }
}
