import org.junit.Test;
import org.omg.CORBA.portable.Streamable;

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

		String actual = add(firstTerm, secondTerm);

		assertEquals(expected, actual);
	}

	@Test
	public void whenAddingIplusIItheResultIsIII() {
		String expected = "III";
		String firstTerm = "I";
		String secondTerm = "II";

		String actual = add(firstTerm, secondTerm);

		assertEquals(expected, actual);
	}

	@Test
	public void whenAddingVplusItheResultIsVI() {
		String expected = "VI";
		String firstTerm = "V";
		String secondTerm = "I";

		String actual = add(firstTerm, secondTerm);

		assertEquals(expected, actual);
	}

	@Test
	public void whenAddingIplusVResultIsVI() {
		String expected = "VI";
		String firstTerm = "I";
		String secondTerm = "V";

		String actual = concatenateWhenTheFirstTermIsI(firstTerm, secondTerm);

		assertEquals(expected, actual);
	}

	@Test
	public void whenAddingIplusXResultIsXI() {
		String expected = "XI";
		String firstTerm = "I";
		String secondTerm = "X";

		String actual = concatenateWhenTheFirstTermIsI(firstTerm, secondTerm);

		assertEquals(expected, actual);
	}

	@Test
	public void whenAddingIplusLResultIsLI() {
		String expected = "LI";
		String firstTerm = "I";
		String secondTerm = "L";

		String actual = concatenateWhenTheFirstTermIsI(firstTerm, secondTerm);

		assertEquals(expected, actual);
	}

	private String concatenateWhenTheFirstTermIsI(String firstTerm, String secondTerm) {
		return secondTerm + firstTerm;
	}

	private String add(String firstTerm, String secondTerm) {
		return firstTerm + secondTerm;
	}



}
