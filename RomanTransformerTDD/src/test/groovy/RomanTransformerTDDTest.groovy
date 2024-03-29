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
		"XVI"      | 16
		"XVII"     | 17
		"XVIII"    | 18
		"XIX"      | 19
		"XX"       | 20
		"XXI"      | 21
		"XXX"      | 30
		"LXIX"     | 69
		"LXXXIII"  | 83
		"XXXVI"    | 36
		"XLI"      | 41
		"XCI"      | 91
		"XCII"     | 92
		"XCIII"    | 93
		"XCIV"     | 94
		"XCV"      | 95
		"XCVIII"   | 98
		"XCIX"     | 99
		"CDI"      | 401
		"CDIV"     | 404
		"CDXLVIII" | 448
		"CDXCV"    | 495
		"CDXCV"    | 495
		"CMI"      | 901
	}
}
