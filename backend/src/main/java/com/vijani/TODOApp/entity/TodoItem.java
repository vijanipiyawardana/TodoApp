package com.vijani.TODOApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todo_item")
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "todo_item_name", nullable = false)
    private String todoItem;

    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)
    private Date addedDate;

}
