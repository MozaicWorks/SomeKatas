import java.util.Map;

/**
 * Created by mozaic.works on 11/24/15.
 */
public class NumeralToRomanTransformer {

    Map<Integer, String> correspondence = NumeralToRomanCorrespondence.getCorrespondence();

    String transformToRoman(int arabicNumeral, int length) {
        int[] digits = getDigits(arabicNumeral, length);
        int multiplicationFactor = ArabicNumeral.ONE.getNumeral();

        String newRomanNumber = "";

        for(int i = 0; i < length; i ++) {
            int digit = digits[i];
            newRomanNumber = concatanateRomanDigitIfLessThanFour(newRomanNumber, digit, multiplicationFactor);
            newRomanNumber = concatanateRomanDigitIfBetweenFiveInclusiveAndNineExclusive(newRomanNumber, digit, multiplicationFactor);
            newRomanNumber = concatanateRomanDigitIfEqualToNine(newRomanNumber, digit, multiplicationFactor);
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


    private String concatanateRomanDigitIfEqualToNine(String newRomanNumber, int digit, int multiplicationFactor) {
        if (digit == ArabicNumeral.NINE.getNumeral()) {
            String romanDigitToAdd = correspondence.get(ArabicNumeral.ONE.getNumeral() * multiplicationFactor) +
                    correspondence.get(ArabicNumeral.TEN.getNumeral() * multiplicationFactor);
            newRomanNumber = romanDigitToAdd + newRomanNumber;
        }
        return newRomanNumber;
    }

    private String concatanateRomanDigitIfLessThanFour(String newRomanNumber, int digit, int multiplicationFactor) {
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

    public static void main (String args[]) {

        if(args.length > 1) {
            throw new IllegalArgumentException("Too many arguments, expected only one");
        }

        if(args.length < 1) {
            throw new IllegalArgumentException("Please enter a number between 1 and 3000");
        }

        String argNumber = args[0];

        int arabicNumeral = Integer.parseInt(argNumber);

        if(arabicNumeral < 1 || arabicNumeral > 3000) {
            throw new IllegalArgumentException("Invalid number, please enter a number between 1 and 3000");
        }

        NumeralToRomanTransformer transformer = new NumeralToRomanTransformer();
        String romanNumeral = transformer.transformToRoman(arabicNumeral, argNumber.length());

        transformer.printRomanNumeral(romanNumeral);
    }
}