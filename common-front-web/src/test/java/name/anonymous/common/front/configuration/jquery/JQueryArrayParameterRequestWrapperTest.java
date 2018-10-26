package name.anonymous.common.front.configuration.jquery;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JQueryArrayParameterRequestWrapperTest {
	private JQueryArrayParameterRequestWrapper jQueryArrayParameterRequestWrapper;
	private HttpServletRequest httpServletRequest;

	@BeforeEach
	public void beforeEach() {
		httpServletRequest = mock(HttpServletRequest.class);
		jQueryArrayParameterRequestWrapper = spy(new JQueryArrayParameterRequestWrapper(httpServletRequest));
	}

	@Test
	void testGetParameterMapEmptyHttpServletRequest() {
		when(((HttpServletRequestWrapper)jQueryArrayParameterRequestWrapper).getParameterMap()).thenReturn(new HashMap<String, String[]>());
		assertEquals(new HashMap<String, String[]>(), jQueryArrayParameterRequestWrapper.getParameterMap());
	}

	@Test
	void testGetParameterMapOneProperty() {
		Map<String, String[]> oldMap = new HashMap<String, String[]>();
		Map<String, String[]> newMap = new HashMap<String, String[]>();
		oldMap.put("property", null);
		newMap.put("property", null);
		when(((HttpServletRequestWrapper)jQueryArrayParameterRequestWrapper).getParameterMap()).thenReturn(oldMap);
		assertEquals(newMap, jQueryArrayParameterRequestWrapper.getParameterMap());
	}

	@Test
	void testGetParameterMapObjectArray() {
		Map<String, String[]> oldMap = new HashMap<String, String[]>();
		Map<String, String[]> newMap = new HashMap<String, String[]>();
		oldMap.put("array[0][property]", null);
		newMap.put("array[0].property", null);
		when(((HttpServletRequestWrapper)jQueryArrayParameterRequestWrapper).getParameterMap()).thenReturn(oldMap);
		assertEquals(newMap, jQueryArrayParameterRequestWrapper.getParameterMap());
	}
}
