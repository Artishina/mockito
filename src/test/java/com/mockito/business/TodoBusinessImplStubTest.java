package com.mockito.business;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import com.mockito.data.stub.TodoServiceStub;
import com.mockito.data.api.TodoService;

public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Polly");
		assertEquals(2, todos.size());
	}

    @Test
    public void checkList() {
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        List<String> actual = todoBusinessImpl.retrieveTodosRelatedToSpring("Polly");
        List<String> expected = Arrays.asList("Learn Spring MVC", "Learn Spring");
      
        assertEquals(actual, expected);        
    }
}