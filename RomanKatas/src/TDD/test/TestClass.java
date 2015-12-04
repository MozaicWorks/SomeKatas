import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by biancal on 04.12.2015.
 */
public class TestClass {

	@Test
	public void whenAddingIplusItheResultIsII() {
		String expected = "II";
		String firstTerm = "I";
		String secondTerm = "I";

		String actual = firstTerm+secondTerm;

		assertEquals(expected, actual);
	}

	@Test
	public void whenAddingIplusIItheResultIsIII() {
		String expected = "III";
		String firstTerm = "I";
		String secondTerm = "II";

		String actual = "III";

		assertEquals(expected, actual);
	}

	@Test
	public void whenAddingVplusItheResultIsVI() {
		String expected = "VI";
		String firstTerm = "V";
		String secondTerm = "I";

		String actual = "VI";

		assertEquals(expected, actual);
	}

}
