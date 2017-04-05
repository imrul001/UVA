package uva10474;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class TestClass10474 extends TestCase {

	@Test
	public void testBinarySearch() {
		Main m = new Main();
		List<Integer> marbels = new ArrayList<Integer>();
		marbels.add(10);
		marbels.add(15);
		marbels.add(0);
		marbels.add(1);
		marbels.add(1);
		marbels.add(100);
		Collections.sort(marbels);
		assertEquals(1, m.binarySearch(1, marbels));
	}

}
