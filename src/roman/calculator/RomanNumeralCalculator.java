package roman.calculator;



import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mozaic.works on 11/25/15.
 */
public class RomanNumeralCalculator {

    public String add(String numeral1, String numeral2) {
        String concatenatedNumeral = numeral1 + " " + numeral2;
        String[] concatenated = splitToChars(concatenatedNumeral);
        TreeMap<String, RomanNumeralGrouping> grouping = getGrouping(concatenated);
        return buildStringFromMapGrouping(grouping);

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
    private TreeMap<String, RomanNumeralGrouping> getGrouping(String[] romanSymbols) {
        TreeMap<String, RomanNumeralGrouping> groupingMap = new TreeMap<>(new SymbolComparator());
        for(int i = 0; i < romanSymbols.length; i++) {
            String symbol = romanSymbols[i];
            if(!symbol.equals(" ")) {
                String nextSymbol = getSymbolIfNotOutOfBound(i+1, romanSymbols);
                addSymbolToMap(symbol, nextSymbol, groupingMap);
            }

        }

        return groupingMap;

    }


    private String getSymbolIfNotOutOfBound(int position, String[] romanSymbols) {
        if(position < romanSymbols.length && !romanSymbols[position].equals(" ")) {
            return romanSymbols[position];
        }

        return null;
    }


    private TreeMap<String, RomanNumeralGrouping> addSymbolToMap(String symbol, String nextSymbol,
                                                                 TreeMap<String, RomanNumeralGrouping> map) {

        RomanNumeralGrouping grouping = map.get(symbol);
        boolean isAddition = true;
        if(nextSymbol != null) {
            isAddition = isPriorityBiggerThanNexts(symbol, nextSymbol);
        }

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
        return romanNumeral.getPriority() <= nexRomanNumeral.getPriority();
    }

    private RomanNumeralGrouping modifyGrouping(String symbol, RomanNumeralGrouping oldGrouping, boolean isAddition) {

        if(isAddition) {
            return modifyGroupingForAddition(symbol, oldGrouping);
        }
        return modifyGroupingForSubtraction(oldGrouping);
    }


    private RomanNumeralGrouping modifyGroupingForAddition(String symbol, RomanNumeralGrouping oldGrouping) {
        int additions = oldGrouping.getAdditions();
        oldGrouping.setAdditions(++additions);
        return oldGrouping;
    }

    private RomanNumeralGrouping modifyGroupingForSubtraction(RomanNumeralGrouping oldGrouping) {
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

    private String buildStringFromMapGrouping(TreeMap<String, RomanNumeralGrouping> map) {
        String numeral = "";
        for(String symbol:map.keySet()) {
            RomanNumeralGrouping grouping = map.get(symbol);
            if(!grouping.needsToBeSubtracted()) {
                numeral += grouping.getNumeralFromGrouping();
            } else {
                numeral = numeral.substring(0, numeral.length() - 2) + grouping.getNumeralFromGrouping() +
                        numeral.substring(numeral.length() -1, numeral.length());
            }
        }

        return numeral;

    }



}
