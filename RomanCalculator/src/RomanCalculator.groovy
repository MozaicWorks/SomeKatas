class RomanCalculator {

    def romanDigits = ['I': new RomanDigit(symbol: 'I', endPosition: 0, numberOfAppearances: 0),
                       'V': new RomanDigit(symbol: 'V', endPosition: 1, doubledSymbol: 'X', numberOfAppearances: 0),
                       'X': new RomanDigit(symbol: 'X', endPosition: 2, numberOfAppearances: 0),
                       'L': new RomanDigit(symbol: 'L', endPosition: 3, doubledSymbol: 'C', numberOfAppearances: 0),
                       'C': new RomanDigit(symbol: 'C', endPosition: 4, numberOfAppearances: 0),
                       'D': new RomanDigit(symbol: 'D', endPosition: 5, doubledSymbol: 'M', numberOfAppearances: 0),
                       'M': new RomanDigit(symbol: 'M', endPosition: 6, numberOfAppearances: 0)]




    def calculate(String firstRomanNo, String secondRomanNo) {
        String[] digits = concatenateRomanNumbersInDigitArray(firstRomanNo, secondRomanNo);
        countAppearancesOfDigitsAndModifyTheMap(digits)
        return buildSumUsingTheRomanDigitMap()
    }

    private splitIntoDigitArray(String romanNumber) {
        return romanNumber.split("(?!^)")
    }

    private concatenateRomanNumbersInDigitArray(String firstRomanNo, String secondRomanNo) {
        def concatenatedNo = firstRomanNo + secondRomanNo
        return splitIntoDigitArray(concatenatedNo)
    }



    private void countAppearancesOfDigitsAndModifyTheMap(String[] digits) {
        for (String digit : digits) {
            RomanDigit romanDigit = romanDigits.get(digit);
            if (romanDigit.doubledSymbol && romanDigit.numberOfAppearances == 1) {
                RomanDigit doubledSymbolDigit = romanDigits.get(romanDigit.doubledSymbol)
                doubledSymbolDigit.numberOfAppearances++
                romanDigit.numberOfAppearances = 0
            } else {
                romanDigit.numberOfAppearances++
            }
        }
    }

    private getFromMapTheRomanDigitsWithAtLeastOneAppearance() {
        return romanDigits.values().findAll{it.numberOfAppearances > 0}
    }

    private orderRomanDigitsByEndposition(List<RomanDigit> digits) {
        digits.sort{it.endPosition}.reverse()
    }



    private buildSumUsingTheRomanDigitMap() {
        def list = getFromMapTheRomanDigitsWithAtLeastOneAppearance()
        orderRomanDigitsByEndposition(list)
        def digits = [];
        for(RomanDigit romanDigit:list) {
            for(int i = 0; i < romanDigit.numberOfAppearances; i++) {
                digits.add(romanDigit.symbol)
            }
        }
        return digits.join();
    }









}
