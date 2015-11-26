package roman.calculator;

import com.sun.deploy.util.StringUtils;


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

    public boolean needsToBeSubtracted() {
        int numberOfDisplays = additions - subtractions;
        if(numberOfDisplays < 0) {
            return true;
        }

        return false;
    }

    public String getNumeralFromGrouping() {
        int numberOfDisplays = additions - subtractions;
        if(numberOfDisplays == 0) {
            return "";
        }
        if (needsToBeSubtracted()) {
            numberOfDisplays *= -1;
        }

        RomanNumeral romanNumeral = RomanNumeral.valueOf(value);
        if(numberOfDisplays >= romanNumeral.getMaxNumberOfAppearances()) {
        // TODO: treat this case
        }
        return new String(new char[numberOfDisplays]).replace("\0", value);

    }
}
