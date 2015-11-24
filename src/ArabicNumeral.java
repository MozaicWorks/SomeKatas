public enum ArabicNumeral {

    ONE(1),
    FOUR(4),
    FIVE(5),
    NINE(9),
    TEN(10),
    FIFTY(50),
    ONE_HUNDRED(100),
    FIVE_HUNDRED(500),
    ONE_THOUSAND(1000);

    private final int numeral;


    private ArabicNumeral(int numeral) {
        this.numeral = numeral;
    }

    public int getNumeral() {
        return numeral;
    }
}
