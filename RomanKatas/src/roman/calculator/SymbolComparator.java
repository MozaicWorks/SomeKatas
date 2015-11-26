package roman.calculator;

import java.util.Comparator;

/**
 * Created by mozaic.works on 11/26/15.
 */
public class SymbolComparator implements Comparator<String> {

    @Override
    public int compare(String symbol1, String symbol2) {
        RomanNumeral numeral1 = RomanNumeral.valueOf(symbol1);
        RomanNumeral numeral2 = RomanNumeral.valueOf(symbol2);

        return numeral1.getPriority() - numeral2.getPriority();
    }
}
