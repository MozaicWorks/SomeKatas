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
}
