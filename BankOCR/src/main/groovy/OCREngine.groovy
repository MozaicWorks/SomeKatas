class OCREngine {

	def recognize(String printedValue) {
		if(printedValue[0] == "_") return 2
		return 1
	}
}
