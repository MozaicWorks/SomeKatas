package roman.calculator;

/**
 * Created by mozaic.works on 11/25/15.
 */
public class RomanNumeralGrouping {

    private String value;
    private int numberOfValuesToAdd;
    private int numberOfValuesToSubstract;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getNumberOfValuesToAdd() {
        return numberOfValuesToAdd;
    }

    public void setNumberOfValuesToAdd(int numberOfValuesToAdd) {
        this.numberOfValuesToAdd = numberOfValuesToAdd;
    }

    public int getNumberOfValuesToSubstract() {
        return numberOfValuesToSubstract;
    }

    public void setNumberOfValuesToSubstract(int numberOfValuesToSubstract) {
        this.numberOfValuesToSubstract = numberOfValuesToSubstract;
    }
}
