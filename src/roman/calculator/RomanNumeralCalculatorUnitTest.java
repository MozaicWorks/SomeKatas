package roman.calculator;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mozaic.works on 11/26/15.
 */
public class RomanNumeralCalculatorUnitTest {


    @Test
    public void testAdd_onePlusOne() {
        RomanNumeralCalculator calculator = new RomanNumeralCalculator();
        String result = calculator.add("I", "I");

        assertEquals("II", result);
    }

    @Test
    public void testAdd_onePlusTwo() {
        RomanNumeralCalculator calculator = new RomanNumeralCalculator();
        String result = calculator.add("II", "I");

        assertEquals("III", result);
    }


    @Test
    @Ignore
    public void testAdd_onePlusThree() {
        RomanNumeralCalculator calculator = new RomanNumeralCalculator();
        String result = calculator.add("I", "III");

        assertEquals("IV", result);
    }

    @Test
    public void testAdd_FourPlusOne() {
        RomanNumeralCalculator calculator = new RomanNumeralCalculator();
        String result = calculator.add("IV", "I");

        assertEquals("V", result);
    }

}
