package roman.calculator;

/**
 * Created by mozaic.works on 11/25/15.
 */
public enum RomanNumeral {
    I(3, "", 7),
    V(1, "I", 6),
    X(3, "V", 5),
    L(1, "X", 4),
    C(3, "L", 3),
    D(1, "C", 2),
    M(3, "D", 1);

    private int maxNumberOfAppearances;
    private String symbolWithCarry;
    private int priority;

    RomanNumeral(int maxNumberOfAppearances, String symbolWithCarry, int priority) {
        this.maxNumberOfAppearances = maxNumberOfAppearances;
        this.symbolWithCarry = symbolWithCarry;
        this.priority = priority;
    }

    public int getMaxNumberOfAppearances() {
        return maxNumberOfAppearances;
    }

    public String getSymbolWithCarry() {
        return symbolWithCarry;
    }

    public int getPriority() {
        return priority;
    }
}
