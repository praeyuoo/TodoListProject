package com.myproject.springmvc.service;

import java.util.Date;
import java.util.List;

import com.myproject.springmvc.model.TodoList;

public interface TodoListService {
	TodoList findById(long id);
	TodoList findByCreateDate(Date createDate);
	void saveTodoList(TodoList todoList);
	void updateTodoList(TodoList todoList);
	void deleteTodoListById(long id);
	List<TodoList> findAllTodoList();
	Boolean isFindTodoListByDateAndDetail(TodoList todoList);
}
