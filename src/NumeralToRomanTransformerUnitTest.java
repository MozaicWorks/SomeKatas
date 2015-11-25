import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mozaic.works on 11/25/15.
 */
public class NumeralToRomanTransformerUnitTest {

    @Test
    public void testTransformer_forOne() {
        NumeralToRomanTransformer transformer = new NumeralToRomanTransformer();
        String result = transformer.getRomanNumeral("1");
        assertEquals("I", result);
    }


    @Test
    public void testTransformer_forFive() {
        NumeralToRomanTransformer transformer = new NumeralToRomanTransformer();
        String result = transformer.getRomanNumeral("5");
        assertEquals("V", result);
    }

    @Test
    public void testTransformer_forTen() {
        NumeralToRomanTransformer transformer = new NumeralToRomanTransformer();
        String result = transformer.getRomanNumeral("10");
        assertEquals("X", result);
    }

    @Test
    public void testTransformer_forFifty() {
        NumeralToRomanTransformer transformer = new NumeralToRomanTransformer();
        String result = transformer.getRomanNumeral("50");
        assertEquals("L", result);
    }



    @Test
    public void testTransformer_forOneHundred() {
        NumeralToRomanTransformer transformer = new NumeralToRomanTransformer();
        String result = transformer.getRomanNumeral("100");
        assertEquals("C", result);
    }

    @Test
    public void testTransformer_forFiveHundred() {
        NumeralToRomanTransformer transformer = new NumeralToRomanTransformer();
        String result = transformer.getRomanNumeral("500");
        assertEquals("D", result);
    }


    @Test
    public void testTransformer_forOneThousand() {
        NumeralToRomanTransformer transformer = new NumeralToRomanTransformer();
        String result = transformer.getRomanNumeral("1000");
        assertEquals("M", result);
    }


    @Test
    public void testTransformer_forTwoThousandNineHundredNinetyNine() {
        NumeralToRomanTransformer transformer = new NumeralToRomanTransformer();
        String result = transformer.getRomanNumeral("1999");
        assertEquals("MCMXCIX", result);
    }


    @Test
    public void testTransformer_forOneThousandSixHundredFortySeven() {
        NumeralToRomanTransformer transformer = new NumeralToRomanTransformer();
        String result = transformer.getRomanNumeral("1647");
        assertEquals("MDCXLVII", result);
    }



}
