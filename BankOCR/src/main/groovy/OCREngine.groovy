class OCREngine {

	def recognize(String printedValue) {
		if(printedValue.size() >= 6 && printedValue[0] == "_" && printedValue[6] == "|") return 3
		if(printedValue[0] == "_") return 2
		return 1
	}
}
