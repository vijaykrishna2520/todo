package com.project.todo.service;

import com.project.todo.exception.BadRequestException;
import com.project.todo.exception.ResourceNotFoundException;
import com.project.todo.entity.TodoEntity;
import com.project.todo.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoService.class);
    public TodoEntity addTodo(TodoEntity todoEntity){
        TodoEntity todo = todoRepository.save(todoEntity);
        LOGGER.info("todo saved is {}",todo);
        return todo;
    }

    public TodoEntity getTodoById(Long id) {
        Optional<TodoEntity> todo = todoRepository.findById(id);
        if (!todo.isPresent()) {
            throw new ResourceNotFoundException("Todo with id "+id+" not found");
        }
        return todo.get();
    }

    public void updateTodoById(Long id, TodoEntity todoEntity) {
        LOGGER.info("Given todo is {}",todoEntity);
        validateRequestBody(todoEntity);
        Optional<TodoEntity> todo = todoRepository.findById(id);
        if(!todo.isPresent()){
            throw new ResourceNotFoundException("Todo with id "+id+" not found");
        }
        todoEntity.setId(id);
        todoRepository.save(todoEntity);
    }

    private void validateRequestBody(TodoEntity todoEntity) {
        if(todoEntity.getTitle() == null || todoEntity.getDesc()==null){
            throw new BadRequestException("Bad request");
        }
    }
}
