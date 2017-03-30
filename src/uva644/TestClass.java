package uva644;

import junit.framework.TestCase;

import org.junit.Test;

public class TestClass extends TestCase {

	@Test
	public void testIsPrefixMatch() {
		Main m = new Main();
		String prefix = "001";
		String code = "0011001";
		assertEquals(false, m.isPrefixMatch(prefix, code));
	}
}
