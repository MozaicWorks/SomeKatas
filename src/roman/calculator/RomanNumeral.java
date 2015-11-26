package roman.calculator;

/**
 * Created by mozaic.works on 11/25/15.
 */
public enum RomanNumeral {
    I(3, "IV", 7),
    V(1, "X", 6),
    X(3, "XL", 5),
    L(1, "C", 4),
    C(3, "CD", 3),
    D(1, "M", 2),
    M(3, "", 1);

    private int maxNumberOfAppearances;
    private String nextNumberToDisplay;
    private int priority;

    RomanNumeral(int maxNumberOfAppearances, String nextNumberToDisplay, int priority) {
        this.maxNumberOfAppearances = maxNumberOfAppearances;
        this.nextNumberToDisplay = nextNumberToDisplay;
        this.priority = priority;
    }

    public int getMaxNumberOfAppearances() {
        return maxNumberOfAppearances;
    }

    public String getNextNumberToDisplay() {
        return nextNumberToDisplay;
    }

    public int getPriority() {
        return priority;
    }
}
