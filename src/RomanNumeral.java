public enum RomanNumeral {
    ONE("I"),
    FIVE("V"),
    TEN("X"),
    FIFTY("L"),
    ONE_HUNDRED("C"),
    FIVE_HUNDRED("D"),
    ONE_THOUSAND("M");

    private final String numeral;

    private RomanNumeral(String numeral) {
        this.numeral = numeral;
    }

    public String getNumeral() {
        return numeral;
    }
}
