package com.vijani.TODOApp.controller;

import com.vijani.TODOApp.entity.TODOItem;
import com.vijani.TODOApp.service.TODOItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TODOItemRESTController {

    @Autowired
    private TODOItemService todoItemService;

    @PostMapping("/todoSave")
    public String todoSave(@RequestBody TODOItem todoItem){
        String output = todoItemService.todoSave(todoItem);
        return output;
    }

    @GetMapping("/todoGet")
    public List<TODOItem> todoGet(){
        List<TODOItem> todoItems = todoItemService.todoGetAll();
        return todoItems;
    }

}
