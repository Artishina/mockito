package com.mockito;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Matchers.*;

public class ListTest {

	@Test
	public void letsMockListSize() {
		List list = mock(List.class);
		Mockito.when(list.size()).thenReturn(10);
		assertEquals(10, list.size());
	}

	@Test
	public void letsMockListSizeWithMultipleReturnValues() {
		List list = mock(List.class);
		Mockito.when(list.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, list.size()); // First Call
		assertEquals(20, list.size()); // Second Call
	}

	@Test
	public void letsMockListGet() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(0)).thenReturn("first");
		assertEquals("first", list.get(0));
		assertNull(list.get(1));
	}

	@Test
	public void letsMockListGetWithAny() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("anyInt");
		// If you are using argument matchers, all arguments
		// have to be provided by matchers.
		assertEquals("anyInt", list.get(0));
		assertEquals("anyInt", list.get(1));
	}

    @Test(expected = RuntimeException.class)
    public void testException() {
        List list = mock(List.class);

        Mockito.when(list.get(anyInt())).thenThrow(new RuntimeException("wrong"));
        
        list.get(0);
    }

}