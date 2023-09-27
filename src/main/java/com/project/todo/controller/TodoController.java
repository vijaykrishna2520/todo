package com.project.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String sayHello() {
        return "It's working bro enjoy ok fine thanks";
    }
}
