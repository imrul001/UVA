package uva644;

import junit.framework.TestCase;

import org.junit.Test;

public class TestClass extends TestCase {

	@Test
	public void testIsPrefixMatch() {
		Main_BF m = new Main_BF();
		String prefix = "001";
		String code = "0011001";
		assertEquals(false, m.isPrefixMatch(prefix, code));
	}
}
