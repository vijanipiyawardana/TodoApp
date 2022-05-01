package com.vijani.TODOApp.service;

import com.vijani.TODOApp.entity.TODOItem;
import com.vijani.TODOApp.repository.TODOItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TODOItemService {

    @Autowired
    TODOItemRepository todoItemRepository;

    public String todoSave(TODOItem item){
        item.setAddedDate(new Date());
        todoItemRepository.save(item);
        return "Successfully saved!";
    }

    public List<TODOItem> todoGetAll(){
        List<TODOItem> todoItemList = todoItemRepository.findAll();
        return todoItemList;
    }
}
