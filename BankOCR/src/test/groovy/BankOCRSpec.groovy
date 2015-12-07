import spock.lang.Specification

class BankOCRSpec extends Specification {

	def "OCR recognizes digit 1"(){
		given:
		def printed1 = """\
|
|"""
		def ocrEngine = new OCREngine()

		when:
		def result = ocrEngine.recognize(printed1)

		then:
		result == 1
	}

	def "OCR recognizes digit 2"(){
		given:
		def printed2 = """\
_
_|
|_"""
		def ocrEngine = new OCREngine()

		when:
		def result = ocrEngine.recognize(printed2)

		then:
		result == 2
	}

}
