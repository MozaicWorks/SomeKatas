import org.junit.Before
import org.junit.Test

class RomanCalculatorTests {

    def romanCalculator

    @Before
    void setup(){
        romanCalculator = new RomanCalculator()
    }

    @Test
    void "I plus I returns II"() {
        assert 'II' == romanCalculator.calculate('I', 'I')
    }

    @Test
    void "I plus II returns III"() {
        assert 'III' == romanCalculator.calculate('I', 'II')
    }

    @Test
    void "I plus V returns VI"() {
        assert 'VI' == romanCalculator.calculate('I', 'V')
    }

    @Test
    void "I plus X returns XI"() {
        assert 'XI' == romanCalculator.calculate('I', 'X')
    }

    @Test
    void "I plus L returns LI"() {
        assert 'LI' == romanCalculator.calculate('I', 'L')
    }

    @Test
    void "I plus C returns CI"() {
        assert 'CI' == romanCalculator.calculate('I', 'C')
    }

    @Test
    void "I plus D returns DI"() {
        assert 'DI' == romanCalculator.calculate('I', 'D')
    }

    @Test
    void "I plus M returns MI"() {
        assert 'MI' == romanCalculator.calculate('I', 'M')
    }

    @Test
    void "V plus X returns XV"() {
        assert 'XV' == romanCalculator.calculate('V', 'X')
    }

    @Test
    void "X plus V returns XV"() {
        assert 'XV' == romanCalculator.calculate('X', 'V')
    }

    @Test
    void "X plus D returns DX"() {
        assert 'DX' == romanCalculator.calculate('X', 'D')
    }

    @Test
    void "X plus X returns XX"() {
        assert 'XX' == romanCalculator.calculate('X', 'X')
    }
}
