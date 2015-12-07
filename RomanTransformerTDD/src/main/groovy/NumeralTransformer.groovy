class NumeralTransformer {
	def numeralMapping = [1: new RomanNumeral(romanValue: "I"),
	                      5: new RomanNumeral(romanValue:  "V"),
	                      10: new RomanNumeral(romanValue:  "X")]
	def transform(int numeral) {
		RomanNumeral romanNumeral = numeralMapping.get(numeral);
		if(romanNumeral) {
			return romanNumeral.romanValue
		}
		return "I" * numeral
	}
}

