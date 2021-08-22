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
	public void usingMockito(String users) {
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        when(todoService.retrieveTodos(anyString())).thenReturn(allTodos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Polyna");
		assertEquals(2, todos.size());

        verify(todoService).retrieveTodos("Polyna");

        todoBusinessImpl.retrieveTodosRelatedToSpring("Polyna");
        verify(todoService, times(2)).retrieveTodos("Polyna");
	}
}