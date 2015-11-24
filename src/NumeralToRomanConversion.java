import java.util.HashMap;
import java.util.Map;

/**
 * Created by mozaic.works on 11/24/15.
 */
public class NumeralToRomanConversion {

    private static final String ROMAN_ONE = "I";
    private static final String ROMAN_FIVE = "V";
    private static final String ROMAN_TEN = "X";
    private static final String ROMAN_FIFTY = "L";
    private static final String ROMAN_ONE_HUNDRED = "C";
    private static final String ROMAN_ONE_THOUSAND = "M";
    private static final int ONE = 1;
    private static final int FIVE = 5;
    private static final int TEN = 10;
    private static final int FIFTY = 50;
    private static final int ONE_HUDRED = 100;
    private static final int ONE_THOUSAND = 1000;



    Map<Integer, String> getArabicToNumeralCorrespondence() {
        Map<Integer, String> map = new HashMap<>();
        map.put(ONE, ROMAN_ONE);
        map.put(FIVE, ROMAN_FIVE);
        map.put(TEN, ROMAN_TEN);
        map.put(FIFTY, ROMAN_FIFTY);
        map.put(ONE_HUDRED, ROMAN_ONE_HUNDRED);
        map.put(ONE_THOUSAND, ROMAN_ONE_THOUSAND);

        return map;

    }

    String convertToRomanNumeral(int arabicNumeral) {

        Map<Integer, String> correspondence = getArabicToNumeralCorrespondence();
        int[] digits = getDigitArray(arabicNumeral);
        int leftNumber = 1;
        int middleNumber = 5;
        int rightNumber = 10;
        int multiplicationFactor = 1;

        String romanNumber = "";
        String newRomanNumber = "";

        for(int i = 0; i < digits.length -1; i ++) {
            int digit = digits[i];
            // if equals to left most number or the middle one
            if(digit == leftNumber|| digit == middleNumber) {
                newRomanNumber = correspondence.get(digit * multiplicationFactor) + romanNumber;
            }
            // else, if digit is smaller than the middle number
            else if(digit < middleNumber) {
                if (digit == middleNumber - leftNumber) {
                    newRomanNumber = correspondence.get(leftNumber * multiplicationFactor) +
                            correspondence.get(middleNumber * multiplicationFactor)
                            + romanNumber;

                }
            }
                else  {
                ifDigitEqualsRightNrMinusLeftNr();
            }
            multiplicationFactor = multiplicationFactor * 10;
        }
        return newRomanNumber;
    }

    private void ifDigitEqualsRightNrMinusLeftNr() {

    }

    int[] getDigitArray(int arabicNumeral) {
        int[] digits = new int[4];
        int i = 0;
        while (arabicNumeral > 0) {
            digits[i] = arabicNumeral % 10;
            arabicNumeral = arabicNumeral / 10;
        }
        return digits;
    }

    boolean isEqualTo(int arabicNumeral, int number) {
        return false;
    }


    boolean isSmallerThan(int arabicNumeral, int number) {
        return false;
    }


    String substract (int arabicNumeral, int number) {
        return null;
    }

    boolean add (int arabicNumeral, int number) {
        return false;
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

        NumeralToRomanConversion conversion = new NumeralToRomanConversion();
        String romanNumeral = conversion.convertToRomanNumeral(arabicNumeral);

        conversion.printRomanNumeral(romanNumeral);





    }
}