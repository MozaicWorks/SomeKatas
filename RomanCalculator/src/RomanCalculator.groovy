class RomanCalculator {

    def romanDigits = ['I': new RomanDigit(symbol: 'I', endPosition: 0),
                       'V': new RomanDigit(symbol: 'V', endPosition: 1, doubledSymbol: 'X'),
                       'X': new RomanDigit(symbol: 'X', endPosition: 2),
                       'L': new RomanDigit(symbol: 'L', endPosition: 3, doubledSymbol: 'C'),
                       'C': new RomanDigit(symbol: 'C', endPosition: 4),
                       'D': new RomanDigit(symbol: 'D', endPosition: 5, doubledSymbol: 'M'),
                       'M': new RomanDigit(symbol: 'M', endPosition: 6)]

    def calculate(firstRomanNo, secondRomanNo) {
        def firstRomanNoDigit = romanDigits.get(firstRomanNo)
        def secondRomanNoDigit = romanDigits.get(secondRomanNo)
        def positionedSumTerms = [firstRomanNoDigit, secondRomanNoDigit].sort{it.endPosition}.reverse().collect{it
                .symbol}
        return positionedSumTerms.join().toString()
    }
}
