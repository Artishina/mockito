package com.mockito.business;

import java.util.ArrayList;
import java.util.List;
import com.mockito.data.api.TodoService;

public class TodoBusinessImpl {
    //TodoBusinessImpl - SUT - System Under Test - The system that we are testing
    //TodoService - dependency - we need to "stub" or "mock" it
	private TodoService todoService;

	TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
}