package roman.calculator;



import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.function.BooleanSupplier;

/**
 * Created by mozaic.works on 11/25/15.
 */
public class RomanNumeralCalculator {

    List<RomanNumeral> listOfProcessedSymbols = new ArrayList<>();

    public String add(String numeral1, String numeral2) {
        String concatenatedNumeral = numeral1 + " " + numeral2;
        String[] concatenated = splitToChars(concatenatedNumeral);
        TreeMap<String, RomanNumeralGrouping> grouping = getGrouping(concatenated);
        TreeMap<String, RomanNumeralGrouping> transformedMap = transformMap(grouping);
        return buildStringFromMapGrouping(transformedMap);

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
        RomanNumeral numeral = RomanNumeral.valueOf(symbol);
        int appearances = oldGrouping.getAppearances();

        if(isAddition) {
            int maxNumberOfAppearances = numeral.getMaxNumberOfAppearances();
            if(appearances == maxNumberOfAppearances) {
                oldGrouping.setCarry(true);
                oldGrouping.setAppearances(0);
            } else {
                oldGrouping.setAppearances(++appearances);
            }

        } else {
            oldGrouping.setAppearances(--appearances);
        }
        return oldGrouping;
    }




    private RomanNumeralGrouping buildNewGrouping(String symbol, boolean isAddition) {
        RomanNumeralGrouping romanNumeralGrouping = new RomanNumeralGrouping();
        romanNumeralGrouping.setValue(symbol);
        if(isAddition) {
            romanNumeralGrouping.setAppearances(1);
        } else {
            romanNumeralGrouping.setAppearances(-1);
        }

        return romanNumeralGrouping;
    }

    private String buildStringFromMapGrouping(TreeMap<String, RomanNumeralGrouping> map) {
        String numeral = "";
        for(String symbol:map.keySet()) {
            RomanNumeralGrouping grouping = map.get(symbol);
            if(!grouping.needsToBeSubtracted()) {
                numeral += grouping.getGroupedSymbols();
            } else {
                numeral = numeral.substring(0, numeral.length() - 1) + grouping.getGroupedSymbols() +
                        numeral.substring(numeral.length() -1, numeral.length());
            }
        }

        return numeral;

    }


    private TreeMap<String, RomanNumeralGrouping> transformMap(TreeMap<String, RomanNumeralGrouping> map) {
        TreeMap<String, RomanNumeralGrouping> newMap = new TreeMap<>(new SymbolComparator());
        for(String symbol: map.descendingKeySet()) {
            RomanNumeral romanNumeral = RomanNumeral.valueOf(symbol);
            RomanNumeralGrouping grouping = map.get(symbol);
            int appearances = grouping.getAppearances();
            int maxNumberOfAppearances = romanNumeral.getMaxNumberOfAppearances();
            if (appearances > maxNumberOfAppearances) {

                appearances = appearances - maxNumberOfAppearances -1;
                String[] symbols = splitToChars(romanNumeral.getSymbolWithCarry());
                for (int i = 0; i < symbols.length; i++) {
                    String numeral = symbols[i];
                    if (!numeral.equals(" ")) {
                        String nextSymbol = getSymbolIfNotOutOfBound(i + 1, symbols);
                        addSymbolToMap(numeral, nextSymbol, newMap);
                    }

                }

                RomanNumeralGrouping newGrouping = newMap.get(symbol);
                if(newGrouping != null) {
                    int newAppearances = newGrouping.getAppearances();
                    newGrouping.setAppearances(newAppearances + appearances);
                }

            }
            else {
                newMap.put(symbol, grouping);
            }
        }
        return newMap;
    }



}
