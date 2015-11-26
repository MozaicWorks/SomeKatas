package roman.transform;

import java.util.Map;

/**
 * Created by mozaic.works on 11/24/15.
 */
public class NumeralToRomanTransformer {

    private static final int LOWER_LIMIT = 1;
    private static final int UPPER_LIMIT = 3000;

    Map<Integer, String> correspondence = NumeralToRomanCorrespondence.getCorrespondence();

    String transformToRoman(String numeral) {
        int arabicNumeral = transformToInt(numeral);
        int length = numeral.length();
        int[] digits = getDigits(arabicNumeral, length);
        int multiplicationFactor = ArabicNumeral.ONE.getNumeral();

        String newRomanNumber = "";

        for(int i = 0; i < length; i ++) {
            int digit = digits[i];
            newRomanNumber = concatenateRomanDigitIfLessThanFour(newRomanNumber, digit, multiplicationFactor);
            newRomanNumber = concatenateRomanDigitIfEqualToFour(newRomanNumber, digit, multiplicationFactor);
            newRomanNumber = concatanateRomanDigitIfBetweenFiveInclusiveAndNineExclusive(newRomanNumber, digit, multiplicationFactor);
            newRomanNumber = concatenateRomanDigitIfEqualToNine(newRomanNumber, digit, multiplicationFactor);
            multiplicationFactor = multiplicationFactor * ArabicNumeral.TEN.getNumeral();
        }
        return newRomanNumber;
    }

    /**
     * returns an array of digits
     * @param arabicNumeral
     * @param length
     * @return
     */
    int[] getDigits(int arabicNumeral, int length) {
        int[] digits = new int[length];
        int i = 0;
        while (arabicNumeral > 0) {
            digits[i] = arabicNumeral % 10;
            arabicNumeral = arabicNumeral / 10;
            i++;
        }
        return digits;
    }


    private String concatenateRomanDigitIfEqualToNine(String newRomanNumber, int digit, int multiplicationFactor) {
        if (digit == ArabicNumeral.NINE.getNumeral()) {
            String romanDigitToAdd = correspondence.get(ArabicNumeral.ONE.getNumeral() * multiplicationFactor) +
                    correspondence.get(ArabicNumeral.TEN.getNumeral() * multiplicationFactor);
            newRomanNumber = romanDigitToAdd + newRomanNumber;
        }
        return newRomanNumber;
    }

    private String concatenateRomanDigitIfEqualToFour(String newRomanNumber, int digit, int multiplicationFactor) {
        if (digit == ArabicNumeral.FOUR.getNumeral()) {
            String romanDigitToAdd = correspondence.get(ArabicNumeral.ONE.getNumeral() * multiplicationFactor) +
                    correspondence.get(ArabicNumeral.FIVE.getNumeral() * multiplicationFactor);
            newRomanNumber = romanDigitToAdd + newRomanNumber;
        }
        return newRomanNumber;
    }

    private String concatenateRomanDigitIfLessThanFour(String newRomanNumber, int digit, int multiplicationFactor) {
        if (digit < ArabicNumeral.FOUR.getNumeral() && digit >= ArabicNumeral.ONE.getNumeral()) {
            String romanDigitToAdd = correspondence.get(ArabicNumeral.ONE.getNumeral() * multiplicationFactor);
            while (digit >  ArabicNumeral.ONE.getNumeral()) {
                romanDigitToAdd += correspondence.get(ArabicNumeral.ONE.getNumeral() * multiplicationFactor);
                digit--;
            }
            newRomanNumber = romanDigitToAdd + newRomanNumber;
        }
        return newRomanNumber;
    }

    private String concatanateRomanDigitIfBetweenFiveInclusiveAndNineExclusive(String newRomanNumber, int digit, int multiplicationFactor) {
        if (digit >= ArabicNumeral.FIVE.getNumeral() && digit < ArabicNumeral.NINE.getNumeral()) {
            String romanDigitToAdd = correspondence.get(ArabicNumeral.FIVE.getNumeral() * multiplicationFactor);
            while (digit > ArabicNumeral.FIVE.getNumeral()) {
                romanDigitToAdd += correspondence.get(ArabicNumeral.ONE.getNumeral() * multiplicationFactor);
                digit--;
            }
            newRomanNumber = romanDigitToAdd + newRomanNumber;
        }
        return newRomanNumber;
    }



    void printRomanNumeral (String romanNumeral) {
        System.out.println("The roman numeral is " + romanNumeral);
    }

    private int transformToInt(String argNumeral) {
        return Integer.parseInt(argNumeral);
    }

    private void validateNumberOfArgs(String args[]) {
        if(args.length != 1) {
            throw new IllegalArgumentException("Please enter a number between 1 and 3000");
        }
    }

    private void validateArabicNumeral(int arabicNumeral) {
        if(arabicNumeral < LOWER_LIMIT || arabicNumeral > UPPER_LIMIT) {
            throw new IllegalArgumentException("Invalid number, please enter a number between "+ LOWER_LIMIT
                    + " and " + UPPER_LIMIT);
        }
    }

    public String getRomanNumeral(String arabicNumeral) {
        return transformToRoman(arabicNumeral);
    }

    public static void main (String args[]) {
        NumeralToRomanTransformer transformer = new NumeralToRomanTransformer();
        transformer.validateNumberOfArgs(args);
        String arg = args[0];
        int arabicNumeral = transformer.transformToInt(arg);
        transformer.validateArabicNumeral(arabicNumeral);

        String romanNumeral = transformer.transformToRoman(arg);
        transformer.printRomanNumeral(romanNumeral);
    }
}