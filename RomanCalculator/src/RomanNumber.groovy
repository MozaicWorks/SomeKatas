class RomanNumber {
	RomanDigit[] digits = []

	public static fromString(String romanNumberAsString) {
		return new RomanNumber(digits:
				romanNumberAsString.collect { character ->
					new RomanDigit(symbol: character)
				}
		)
	}
}
