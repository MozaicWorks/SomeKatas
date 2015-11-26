package roman.calculator;

/**
 * Created by mozaic.works on 11/25/15.
 */
public class RomanNumeralGrouping {

    private String value;
    private int additions;
    private int subtractions;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getAdditions() {
        return additions;
    }

    public void setAdditions(int additions) {
        this.additions = additions;
    }

    public int getSubtractions() {
        return subtractions;
    }

    public void setSubtractions(int subtractions) {
        this.subtractions = subtractions;
    }
}
