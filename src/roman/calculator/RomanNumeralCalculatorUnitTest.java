package roman.calculator;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mozaic.works on 11/26/15.
 */
public class RomanNumeralCalculatorUnitTest {


    @Test
    public void testAdd_onePlusOneIsTwo() {
        RomanNumeralCalculator calculator = new RomanNumeralCalculator();
        String result = calculator.add("I", "I");

        assertEquals("II", result);
    }

    @Test
    public void testAdd_onePlusTwoIsThree() {
        RomanNumeralCalculator calculator = new RomanNumeralCalculator();
        String result = calculator.add("II", "I");

        assertEquals("III", result);
    }


    @Test
    @Ignore
    public void testAdd_onePlusThreeIsFour() {
        RomanNumeralCalculator calculator = new RomanNumeralCalculator();
        String result = calculator.add("I", "III");

        assertEquals("IV", result);
    }

    @Test
    public void testAdd_OnePlusFourIsFive() {
        RomanNumeralCalculator calculator = new RomanNumeralCalculator();
        String result = calculator.add("I", "IV");

        assertEquals("V", result);
    }

    @Test
    public void testAdd_OnePlusFiveIsSix() {
        RomanNumeralCalculator calculator = new RomanNumeralCalculator();
        String result = calculator.add("I", "V");

        assertEquals("VI", result);
    }

    @Test
    public void testAdd_OnePlusSixIsSeven() {
        RomanNumeralCalculator calculator = new RomanNumeralCalculator();
        String result = calculator.add("I", "VI");

        assertEquals("VII", result);
    }


    @Test
    public void testAdd_OnePlusSevenIsEight() {
        RomanNumeralCalculator calculator = new RomanNumeralCalculator();
        String result = calculator.add("I", "VII");

        assertEquals("VIII", result);
    }


    @Test
    @Ignore
    public void testAdd_OnePlusEightIsNine() {
        RomanNumeralCalculator calculator = new RomanNumeralCalculator();
        String result = calculator.add("I", "VIII");

        assertEquals("IX", result);
    }

    @Test
    public void testAdd_OnePlusNineIsTen() {
        RomanNumeralCalculator calculator = new RomanNumeralCalculator();
        String result = calculator.add("I", "IX");

        assertEquals("X", result);
    }


}
