import spock.lang.Specification
import spock.lang.Unroll

import static junit.framework.Assert.assertEquals

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
		assertEquals(romanValue, result)

		where:
		romanValue | decimalValue
		"I"        | 1
		"II"       | 2
		"III"      | 3
		"V"        | 5
		"X"        | 10
	}
}
