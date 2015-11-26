package roman.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mozaic.works on 11/26/15.
 */
public class RomanNumeralCalculatorUnitTest {


    @Test
    public void testAdd() {
        RomanNumeralCalculator calculator = new RomanNumeralCalculator();
        String result = calculator.add("I", "I");

        assertEquals("II", result);
    }
}
