package name.anonymous.common.front.utils.uri.jquery;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JqueryUtilsTest {
	private StringBuilder sb;

	@BeforeEach
	public void before() {
		sb = new StringBuilder();
	}

	@Test
	public void testReplaceBracketOneProperty() {
		JqueryUtils.replaceBracket("order", sb);
		assertEquals("property must not be updated", "order", sb.toString());
	}

	@Test
	public void testReplaceBracketObject() {
		JqueryUtils.replaceBracket("column[data][property]", sb);
		assertEquals("property must not be updated", "column.data.property", sb.toString());
	}

	@Test
	public void testReplaceBracketObjectArray() {
		JqueryUtils.replaceBracket("columns[0][data]", sb);
		assertEquals("property must not be updated", "columns[0].data", sb.toString());
	}

	@Test
	public void testReplaceBracketOpenBracketWithoutClosedBracket() {
		JqueryUtils.replaceBracket("test[", sb);
		assertEquals("property must not be updated", "test[", sb.toString());
	}

	@Test
	public void testReplaceBracketBracketWithoutContent() {
		JqueryUtils.replaceBracket("test[]", sb);
		assertEquals("property must not be updated", "test[]", sb.toString());
	}
}
