import java.util.HashMap;
import java.util.Map;

public class NumeralToRomanCorrespondence {

    public static Map<Integer, String> getCorrespondence() {
        Map<Integer, String> correspondence = new HashMap<>();
        correspondence.put(ArabicNumeral.ONE.getNumeral(), RomanNumeral.ONE.getNumeral());
        correspondence.put(ArabicNumeral.FIVE.getNumeral(), RomanNumeral.FIVE.getNumeral());
        correspondence.put(ArabicNumeral.TEN.getNumeral(), RomanNumeral.TEN.getNumeral());
        correspondence.put(ArabicNumeral.FIFTY.getNumeral(), RomanNumeral.FIFTY.getNumeral());
        correspondence.put(ArabicNumeral.ONE_HUNDRED.getNumeral(), RomanNumeral.ONE_HUNDRED.getNumeral());
        correspondence.put(ArabicNumeral.FIVE_HUNDRED.getNumeral(), RomanNumeral.FIVE_HUNDRED.getNumeral());
        correspondence.put(ArabicNumeral.ONE_THOUSAND.getNumeral(), RomanNumeral.ONE_THOUSAND.getNumeral());

        return correspondence;
    }
}
