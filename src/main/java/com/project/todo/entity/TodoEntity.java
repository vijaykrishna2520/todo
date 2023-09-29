package com.project.todo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "todo")
public class TodoEntity {
    @Id
    private Long id;
    private String title;
    private String desc;

}

