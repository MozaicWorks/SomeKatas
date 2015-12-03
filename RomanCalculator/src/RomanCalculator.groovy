class RomanCalculator {

	def romanDigits = ['I': new RomanDigit(symbol: 'I', endPosition: 0, quadrupledSymbol: 'V', numberOfAppearances: 0),
	                   'V': new RomanDigit(symbol: 'V', endPosition: 1, doubledSymbol: 'X', numberOfAppearances: 0),
	                   'X': new RomanDigit(symbol: 'X', endPosition: 2, quadrupledSymbol: 'L', numberOfAppearances: 0),
	                   'L': new RomanDigit(symbol: 'L', endPosition: 3, doubledSymbol: 'C', numberOfAppearances: 0),
	                   'C': new RomanDigit(symbol: 'C', endPosition: 4, quadrupledSymbol: 'D', numberOfAppearances: 0),
	                   'D': new RomanDigit(symbol: 'D', endPosition: 5, doubledSymbol: 'M', numberOfAppearances: 0),
	                   'M': new RomanDigit(symbol: 'M', endPosition: 6, numberOfAppearances: 0)]


	def calculate(String firstRomanNo, String secondRomanNo) {
		countAndStoreNumberOfAppearancesOfDigit(firstRomanNo)
		countAndStoreNumberOfAppearancesOfDigit(secondRomanNo)
		transformDoubledAndQuadrupledSymbol()
		return buildSumUsingTheRomanDigitMap()
	}


	private void countAndStoreNumberOfAppearancesOfDigit(String romanNumber) {
		String[] digits = romanNumber.collect { it }

		romanNumber.eachWithIndex { digit, index ->
			updateNumberOfAppearancesForRomanDigit(digit, digits, index)
		}
	}

	private void updateNumberOfAppearancesForRomanDigit(String digit, String[] digits, int i) {
		RomanDigit romanDigit = romanDigits.get(digit)

		int count = romanDigit.numberOfAppearances
		if (isCurrentRomanDigitBiggerThanNextRomanDigit(digits, i)) {
			count++
		} else {
			count--
		}
		romanDigit.numberOfAppearances = count
	}


	private void transformDoubledAndQuadrupledSymbol() {
		def mapChanged = false
		for (String symbol : romanDigits.keySet()) {
			RomanDigit romanDigit = romanDigits.get(symbol)
			if (romanDigit.doubledSymbol && romanDigit.numberOfAppearances > 1) {
				RomanDigit doubledSymbolDigit = romanDigits.get(romanDigit.doubledSymbol)
				doubledSymbolDigit.numberOfAppearances++
				romanDigit.numberOfAppearances = romanDigit.numberOfAppearances - 2
				mapChanged = true
			} else if (romanDigit.quadrupledSymbol && romanDigit.numberOfAppearances > 3) {
				RomanDigit quadrupledSymbol = romanDigits.get(romanDigit.quadrupledSymbol)
				quadrupledSymbol.numberOfAppearances++
				romanDigit.numberOfAppearances = romanDigit.numberOfAppearances - 5;
				mapChanged = true
			}
		}

		if (mapChanged) {
			transformDoubledAndQuadrupledSymbol()
		}
	}

	boolean isCurrentRomanDigitBiggerThanNextRomanDigit(String[] digits, int i) {
		RomanDigit romanDigit = computeRomanDigit(i, digits)
		RomanDigit nextRomanDigit = computeRomanDigit(i + 1, digits)
		return romanDigit.biggerThan(nextRomanDigit)
	}

	private RomanDigit computeRomanDigit(int i, String[] romanNumberAsStringArray) {
		RomanDigit nextRomanDigit = new RomanDigit(endPosition: -1)
		def atTheEndOfTheNumber = (i >= romanNumberAsStringArray.length)
		if (!atTheEndOfTheNumber) {
			String nextDigit = romanNumberAsStringArray[i]
			nextRomanDigit = romanDigits[nextDigit]
		}
		return nextRomanDigit
	}


	private getDigitsWithAtLeastOneAppearanceInOrder() {
		return romanDigits.values()
				.findAll { it.numberOfAppearances != 0 }
				.sort { it.endPosition }
				.reverse()
	}

	private buildSumUsingTheRomanDigitMap() {
		def list = getDigitsWithAtLeastOneAppearanceInOrder()
		def digits = []
		def romanDigit
		def tempDigit
		for (int i = 0; i < list.size(); i++) {
			romanDigit = list[i]
			if (romanDigit.numberOfAppearances < 0) {
				def lengthOfDigits = digits.size()
				tempDigit = digits.get(lengthOfDigits - 1)
				digits.set(lengthOfDigits - 1, romanDigit.symbol)
				digits.add(tempDigit)
			}
			for (def j = 0; j < romanDigit.numberOfAppearances; j++) {
				digits.add(romanDigit.symbol)
			}
		}
		return digits.join();
	}
}
