package com.project.todo.repository;

import com.project.todo.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<TodoEntity,Long> {
}
