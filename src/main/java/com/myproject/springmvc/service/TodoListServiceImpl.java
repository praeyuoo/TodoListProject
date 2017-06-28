package com.myproject.springmvc.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.springmvc.model.TodoList;
@Service("todoListService")
@Transactional
public class TodoListServiceImpl implements TodoListService {
	private static List<TodoList> todoLists;
	private static final AtomicLong counter = new AtomicLong();
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
	
	static{
		todoLists= dummyTodoListData();
    }
	public TodoList findById(long id) {
		for (TodoList todo : todoLists) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	public TodoList findByCreateDate(Date createDate) {
		for (TodoList todo : todoLists) {
			if (todo.getCreateDate().compareTo(createDate) == 0) {
				return todo;
			}
		}
		return null;
	}
	public void saveTodoList(TodoList todoList) {
		todoList.setId(counter.incrementAndGet());
		todoLists.add(todoList);
		
	}
	public void updateTodoList(TodoList todoList) {
		int index = todoLists.indexOf(todoList);
		todoLists.set(index, todoList);
		
	}
	public void deleteTodoListById(long id) {
		for (Iterator<TodoList> iterator = todoLists.iterator(); iterator.hasNext();) {
			TodoList todoList = iterator.next();
			if (todoList.getId() == id) {
				iterator.remove();
			}

		
	}}
	
	public List<TodoList> findAllTodoList() {
		return todoLists;
	}
	
	public Boolean isFindTodoListByDateAndDetail(TodoList todoList) {
		for (TodoList list : todoLists) {
			if (list.getTodoListDetail().equalsIgnoreCase(todoList.getTodoListDetail())
					&& (list.getCreateDate().compareTo(todoList.getCreateDate()) == 0)) {
				return false;
			}
		}
		return true;
	}

	private static List<TodoList> dummyTodoListData() {
		List<TodoList> todoLists = new ArrayList<TodoList>();
		try {
			todoLists.add(new TodoList(counter.incrementAndGet(), "Meeting", "User",
					DATE_FORMAT.parse("27/06/2017 09:00:00"), 0, null));
			todoLists.add(new TodoList(counter.incrementAndGet(), "Buying Iphone Mobile at The mall", "User",
					DATE_FORMAT.parse("27/06/2017 10:00:00"), 0, null));
			todoLists.add(new TodoList(counter.incrementAndGet(), "playing game", "User",
					DATE_FORMAT.parse("27/06/2017 13:00:00"), 0, null));
			todoLists.add(new TodoList(counter.incrementAndGet(), "chatting with Friend", "User",
					DATE_FORMAT.parse("27/06/2017 15:30:00"), 0, null));
			todoLists.add(new TodoList(counter.incrementAndGet(), "Reading java programming book", "User",
					DATE_FORMAT.parse("27/06/2017 13:00:00"), 0, null));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return todoLists;
	}

}
