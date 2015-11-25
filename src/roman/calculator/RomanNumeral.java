package roman.calculator;

/**
 * Created by mozaic.works on 11/25/15.
 */
public enum RomanNumeral {
    I(3, "IV", 1),
    V(1, "X", 2),
    X(3, "XL", 3),
    L(1, "C", 4),
    C(3, "CD", 5),
    D(1, "M", 6),
    M(3, "", 7);

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
