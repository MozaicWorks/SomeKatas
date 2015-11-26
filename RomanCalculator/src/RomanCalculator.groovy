class RomanCalculator {

    def romanDigits = ['I':0, 'V':1, 'X':2]

    def calculate(firstRomanNo, secondRomanNo) {
        def firstRomanNoDigit = new RomanDigit(symbol: firstRomanNo, endPosition: romanDigits.get(firstRomanNo))
        def secondRomanNoDigit = new RomanDigit(symbol: secondRomanNo, endPosition: romanDigits.get(secondRomanNo))
        def positionedSumTerms = [firstRomanNoDigit, secondRomanNoDigit].sort{it.endPosition}.reverse().collect{it
                .symbol}
        return positionedSumTerms.join().toString()
    }
}
