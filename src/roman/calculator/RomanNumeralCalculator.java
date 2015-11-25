package roman.calculator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mozaic.works on 11/25/15.
 */
public class RomanNumeralCalculator {

    public String add(String numeral1, String numeral2) {
        return null;
    }

    private String[] splitToChars(String numeral) {
        return numeral.split("(?!^)");
    }

    /**
     * constructs a map between the value of a roman symbol (ex I, V, X, etc)
     * and its correspoding {@link RomanNumeralGrouping}
     * @param romanSymbols
     * @return
     */
    private Map<String, RomanNumeralGrouping> getGrouping(String[] romanSymbols) {
        Map<String, RomanNumeralGrouping> groupingMap = new HashMap<>();
        for(int i = 0; i < romanSymbols.length; i++) {
            String symbol = romanSymbols[i];
            String nextSymbol = getSymbolIfNotOutOfBound(i+1, romanSymbols);
            addSymbolToMap(symbol, nextSymbol, groupingMap);
        }

        return groupingMap;

    }


    private String getSymbolIfNotOutOfBound(int position, String[] romanSymbols) {
        if(position < romanSymbols.length) {
            return romanSymbols[position];
        }

        return null;
    }


    private Map<String, RomanNumeralGrouping> addSymbolToMap(String symbol, String nextSymbol,
                                                             Map<String, RomanNumeralGrouping> map) {
        if(map.get(symbol) != null) {
            RomanNumeralGrouping grouping = map.get(symbol);
            RomanNumeral romanNumeral = RomanNumeral.valueOf(symbol);

        }

        return map;

    }



}
