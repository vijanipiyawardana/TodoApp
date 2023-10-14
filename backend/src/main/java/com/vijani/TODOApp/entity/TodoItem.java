package com.vijani.TODOApp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "todo_item")
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "todo_title", nullable = false)
    private String title;

    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)
    private Date addedDate;

    @Column(name = "todo_status", nullable = false)
    private TodoStatus status;

    public static TodoItem createTodoWithDefaults(String title) {
        return TodoItem.builder()
                .title(title)
                .status(TodoStatus.TODO)
                .addedDate(new Date())
                .build();
    }
}
