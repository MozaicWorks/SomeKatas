class NumeralTransformer {
	def numeralMapping = [1000: "M",
	                      900 : "CM",
	                      500 : "D",
	                      400 : "CD",
	                      100 : "C",
	                      90  : "XC",
	                      50  : "L",
	                      40  : "XL",
	                      10  : "X",
	                      9   : "IX",
	                      5   : "V",
	                      4   : "IV",
	                      1   : "I"]

	def transform(int numeralToBeTransformed) {
		def romanNumeral = numeralMapping.get(numeralToBeTransformed)
		if (romanNumeral) {
			return romanNumeral
		}

		for (int it:numeralMapping.keySet()) {
			if(numeralToBeTransformed > it) {
				def roman = numeralMapping.get(it)
				return roman + transform(numeralToBeTransformed - it)
			}
		}
	}
}

