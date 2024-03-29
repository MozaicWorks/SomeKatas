import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
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
