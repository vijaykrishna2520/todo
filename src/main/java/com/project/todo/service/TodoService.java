package com.project.todo.service;

import com.project.todo.controller.Exception.ResourceNotFoundException;
import com.project.todo.entity.TodoEntity;
import com.project.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    public void addTodo(TodoEntity todoEntity){
        throw new ResourceNotFoundException("not found");
//        todoRepository.save(todoEntity);
    }
}
