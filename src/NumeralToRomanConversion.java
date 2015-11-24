/**
 * Created by mozaic.works on 11/24/15.
 */
public class NumeralToRomanConversion {


    String convertToRomanNumeral(int arabicNumeral) {
        return null;
    }

    void printRomanNumeral (String romanNumeral) {
        System.out.println("The roman numeral is " + romanNumeral);
    }

    public static void main (String args[]) {

        String argNumber = args[0];
        if(args.length > 1) {
            throw new IllegalArgumentException("Too many arguments, expected only one");
        }

        if(args.length < 1) {
            throw new IllegalArgumentException("Please enter a number between 1 and 3000");
        }

        int arabicNumeral = Integer.parseInt(argNumber);

        if(arabicNumeral < 1 || arabicNumeral > 3000) {
            throw new IllegalArgumentException("Invalid number, please enter a number between 1 and 3000");
        }

        NumeralToRomanConversion romanNumeral = new NumeralToRomanConversion();
        String romanNumeral = romanNumeral.convertToRomanNumeral(arabicNumeral);

        printRomanNumeral(romanNumeral);




    }
}