package com.project.todo.controller;

import com.project.todo.entity.TodoEntity;
import com.project.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String sayHello() {
        return "It's working bro enjoy ok fine thanks";
    }
//    add a todo
    @RequestMapping(value="/todo",method = RequestMethod.POST)
    public void addTodo(@RequestBody TodoEntity todoEntity){
        todoService.addTodo(todoEntity);
    }
}
