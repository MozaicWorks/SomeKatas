class RomanDigit {

    def symbol
    def endPosition
    def doubledSymbol
    def quadrupledSymbol
    def numberOfAppearances

    boolean biggerThan(RomanDigit nextRomanDigit) {
	 return endPosition >= nextRomanDigit.endPosition
 }
}
