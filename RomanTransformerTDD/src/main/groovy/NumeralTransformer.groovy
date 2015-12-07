class NumeralTransformer {
	def numeralMapping = [1   : new RomanNumeral(romanValue: "I"),
	                      4   : new RomanNumeral(romanValue: "IV"),
	                      5   : new RomanNumeral(romanValue: "V"),
	                      9   : new RomanNumeral(romanValue: "IX"),
	                      10  : new RomanNumeral(romanValue: "X"),
	                      40  : new RomanNumeral(romanValue: "XL"),
	                      50  : new RomanNumeral(romanValue: "L"),
	                      90  : new RomanNumeral(romanValue: "XC"),
	                      100 : new RomanNumeral(romanValue: "C"),
	                      400 : new RomanNumeral(romanValue: "CD"),
	                      500 : new RomanNumeral(romanValue: "D"),
	                      900 : new RomanNumeral(romanValue: "CM"),
	                      1000: new RomanNumeral(romanValue: "M")]

	def transform(int numeral) {
		RomanNumeral romanNumeral = numeralMapping.get(numeral);

		if (romanNumeral) {
			return romanNumeral.romanValue
		}

		def values = [1000, 500, 100, 50, 10, 5]
		for (def it:values) {
			if(numeral > it) {
				return romanNumeralOverValue(numeral, it)
			}
		}

		return "I" * numeral
	}

	private def romanNumeralOverValue(int numeral, int decimal) {
		def roman = numeralMapping.get(decimal).romanValue
		if(numeral > 9 * decimal) return numeralMapping.get(9*decimal).romanValue+ transform(numeral - 9* decimal)
		if(numeral > 4 * decimal) return numeralMapping.get(4*decimal).romanValue+ transform(numeral - 4* decimal)
		if(numeral - decimal >= 4) return roman + transform(numeral - decimal)
		return roman + ("I" * (numeral - decimal))
	}

}

