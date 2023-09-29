package com.project.todo.controller;

import com.project.todo.entity.TodoEntity;
import com.project.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String sayHello() {
        return "It's working bro enjoy ok fine thanks";
    }
//    add a todo
    @RequestMapping(value="/todos",method = RequestMethod.POST)
    public ResponseEntity<String> addTodo(@RequestBody TodoEntity todoEntity){
        TodoEntity todo = todoService.addTodo(todoEntity);
        return new ResponseEntity<>("Todo added successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/todos/{id}",method = RequestMethod.GET)
    public TodoEntity getTodoById(@PathVariable(value = "id") Long id){
        return todoService.getTodoById(id);
    }

    @RequestMapping(value = "todos/{id}",method = RequestMethod.PUT)
    public void updateTodoById(@PathVariable(value = "id") Long id,@RequestBody TodoEntity todoEntity){
        todoService.updateTodoById(id,todoEntity);
    }
}
