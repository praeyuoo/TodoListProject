package com.myproject.springmvc.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.myproject.springmvc.model.TodoList;
import com.myproject.springmvc.service.TodoListService;

@RestController
public class MyProjectController {
	
	@Autowired
	TodoListService todoListService;
	
    @RequestMapping(value = "/todolist/all", method = RequestMethod.GET)
    public ResponseEntity<List<TodoList>> listAllTodoLists() {
        List<TodoList> todoLists = todoListService.findAllTodoList();
        if(todoLists.isEmpty()){
            return new ResponseEntity<List<TodoList>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<TodoList>>(todoLists, HttpStatus.OK);
    }

    @RequestMapping(value = "/todolist/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoList> getTodoList(@PathVariable("id") long id) {
        TodoList todoList = todoListService.findById(id);
        if (todoList == null) {
            return new ResponseEntity<TodoList>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TodoList>(todoList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/todolist/", method = RequestMethod.POST)
    public ResponseEntity<Void> createTodoList(@RequestBody TodoList todoList,UriComponentsBuilder ucBuilder) {
        if (!todoListService.isFindTodoListByDateAndDetail(todoList)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        todoListService.saveTodoList(todoList);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/todolist/{id}").buildAndExpand(todoList.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/todolist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TodoList> updateTodoList(@PathVariable("id") long id, @RequestBody TodoList todoList) {
    	TodoList todoCurr = todoListService.findById(id);
        if (todoCurr==null) {
            return new ResponseEntity<TodoList>(HttpStatus.NOT_FOUND);
        }
        todoCurr.setStopDate(new Date());
        todoCurr.setIsStatus(1);
         
        todoListService.updateTodoList(todoCurr);
        return new ResponseEntity<TodoList>(todoCurr, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/todolist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TodoList> deleteTodoList(@PathVariable("id") long id) {
        TodoList todoList = todoListService.findById(id);
        if (todoList == null) {
            return new ResponseEntity<TodoList>(HttpStatus.NOT_FOUND);
        }
        
        todoListService.deleteTodoListById(id);
        return new ResponseEntity<TodoList>(HttpStatus.NO_CONTENT);
    }
}
