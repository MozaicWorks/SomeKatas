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
        if (isTwiceAppearanceOfUniqueDigit(firstRomanNoDigit, secondRomanNoDigit)){
            return firstRomanNoDigit.doubledSymbol
        }
        def positionedSumTerms = makeTheSumOfTheDigitsInASymbolsArray(firstRomanNoDigit, secondRomanNoDigit)
        return positionedSumTerms.join().toString()
    }

    private isTwiceAppearanceOfUniqueDigit(RomanDigit firstRomanNoDigit, RomanDigit secondRomanNoDigit) {
        sameSymbolSumTerms(firstRomanNoDigit, secondRomanNoDigit) && cannotAppearTwice(firstRomanNoDigit)
    }

    private cannotAppearTwice(RomanDigit firstRomanNoDigit) {
        firstRomanNoDigit.doubledSymbol
    }

    private sameSymbolSumTerms(RomanDigit firstRomanNoDigit, RomanDigit secondRomanNoDigit) {
        firstRomanNoDigit.symbol == secondRomanNoDigit.symbol
    }

    private makeTheSumOfTheDigitsInASymbolsArray(RomanDigit firstRomanNoDigit, RomanDigit secondRomanNoDigit) {
        [firstRomanNoDigit, secondRomanNoDigit]
                .sort { it.endPosition }
                .reverse()
                .collect {it.symbol}
    }
}
