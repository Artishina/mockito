package com.mockito.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyString;
import java.util.Arrays;
import java.util.List;
import com.mockito.data.api.TodoService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TodoBusinessImplMockitoTest {

	@ParameterizedTest
	@ValueSource(strings = {
			"Polyna", "Sasha", "Nastya"
	})
	public void usingMockito(String user) {
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		List<String> polynaTodos = Arrays.asList("Learn Java", "Learn to Sing", "Learn Spring");

        when(todoService.retrieveTodos(anyString())).thenReturn(allTodos);
        when(todoService.retrieveTodos("Polyna")).thenReturn(polynaTodos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring(user);
		assertEquals(2, todos.size());

        verify(todoService).retrieveTodos(user);

        todoBusinessImpl.retrieveTodosRelatedToSpring(user);
        verify(todoService, times(2)).retrieveTodos(user);
	}
}