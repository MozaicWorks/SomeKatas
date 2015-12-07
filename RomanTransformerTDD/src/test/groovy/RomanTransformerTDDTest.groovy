import spock.lang.Specification
import spock.lang.Unroll

class RomanTransformerTDDTest extends Specification {
	def numeralTransformer

	def setup() {
		numeralTransformer = new NumeralTransformer()
	}


	@Unroll
	def "#decimalValue is #romanValue"(romanValue, decimalValue) {
		when:
		def result = numeralTransformer.transform(decimalValue)

		then:
		romanValue == result

		where:
		romanValue | decimalValue
		"I"        | 1
		"II"       | 2
		"III"      | 3
		"V"        | 5
		"X"        | 10
		"L"        | 50
		"C"        | 100
		"D"        | 500
		"M"        | 1000
		"IV"       | 4
		"IX"       | 9
		"XL"       | 40
		"XC"       | 90
		"CD"       | 400
		"CM"       | 900
		"VI"       | 6
		"VII"      | 7
		"XI"       | 11
		"LI"       | 51
		"LII"      | 52
		"CII"      | 102
		"XV"       | 15
		"XIV"      | 14
	}
}
