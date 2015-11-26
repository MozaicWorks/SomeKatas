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

        RomanNumeralGrouping grouping = map.get(symbol);
        boolean isAddition = isPriorityBiggerThanNexts(symbol, nextSymbol);
        RomanNumeralGrouping groupingToAdd;
        if(map.get(symbol) != null) {
            groupingToAdd = modifyGrouping(symbol, grouping, isAddition);
        } else {
            groupingToAdd = buildNewGrouping(symbol, isAddition);

        }

        map.put(symbol, groupingToAdd);

        return map;

    }

    private boolean isPriorityBiggerThanNexts(String symbol, String nextSymbol) {
        RomanNumeral romanNumeral = RomanNumeral.valueOf(symbol);
        RomanNumeral nexRomanNumeral = RomanNumeral.valueOf(nextSymbol);
        return romanNumeral.getPriority() > nexRomanNumeral.getPriority();
    }

    private RomanNumeralGrouping modifyGrouping(String symbol, RomanNumeralGrouping oldGrouping, boolean isAddition) {

        if(isAddition) {
            return modifyGroupingForAddition(symbol, oldGrouping);
        }
        return modifyGroupingForSubtraction(symbol, oldGrouping);
    }


    private RomanNumeralGrouping modifyGroupingForAddition(String symbol, RomanNumeralGrouping oldGrouping) {
        int additions = oldGrouping.getAdditions();
        RomanNumeral romanNumeral = RomanNumeral.valueOf(symbol);
        if(additions == romanNumeral.getMaxNumberOfAppearances()) {
            // TODO: addSymbolToMap(romanNumeral.getNextNumberToDisplay(), )
            return oldGrouping;
        }

        oldGrouping.setAdditions(++additions);
        return oldGrouping;
    }

    private RomanNumeralGrouping modifyGroupingForSubtraction(String symbol, RomanNumeralGrouping oldGrouping) {
        int subtractions = oldGrouping.getSubtractions();
        oldGrouping.setSubtractions(++subtractions);
        return oldGrouping;
    }


    private RomanNumeralGrouping buildNewGrouping(String symbol, boolean isAddition) {
        RomanNumeralGrouping romanNumeralGrouping = new RomanNumeralGrouping();
        romanNumeralGrouping.setValue(symbol);
        if(isAddition) {
            romanNumeralGrouping.setAdditions(1);
        } else {
            romanNumeralGrouping.setSubtractions(1);
        }

        return romanNumeralGrouping;
    }



}
