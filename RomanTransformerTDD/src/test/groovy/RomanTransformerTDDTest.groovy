import spock.lang.Specification

import static junit.framework.Assert.assertEquals

class RomanTransformerTDDTest extends Specification {

	def "1 is I"() {
		given:
		def numeral = 1
		def numeralTransformer = new NumeralTransformer()


		when:
		def result = numeralTransformer.transform(numeral)

		then:
		assertEquals("I", result)
	}

	def "2 is II"() {
		given:
		def numeral = 2
		def numeralTransformer = new NumeralTransformer()


		when:
		def result = numeralTransformer.transform(numeral)

		then:
		assertEquals("II", result)
	}

	def "3 is III"() {
		given:
		def numeral = 2
		def numeralTransformer = new NumeralTransformer()


		when:
		def result = numeralTransformer.transform(numeral)

		then:
		assertEquals("III", result)
	}

}
