package roman.calculator;


/**
 * Created by mozaic.works on 11/25/15.
 */
public class RomanNumeralGrouping {

    private String value;

    private int appearances;

    private boolean carry;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public int getAppearances() {
        return appearances;
    }

    public void setAppearances(int appearances) {
        this.appearances = appearances;
    }

    public boolean isCarry() {
        return carry;
    }

    public void setCarry(boolean carry) {
        this.carry = carry;
    }

    public boolean needsToBeSubtracted() {
        return appearances < 0;
    }


    public String getGroupedSymbols() {
        if(appearances == 0) {
            return "";
        }
        if (needsToBeSubtracted()) {
            appearances *= -1;
        }

        return new String(new char[appearances]).replace("\0", value);

    }
}
