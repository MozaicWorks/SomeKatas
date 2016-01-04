class IPiece extends TetrisPiece {

	IPiece(def currentLengthPosition, def currentWidthPosition, def length = 4, def width = 4) {
		this.currentLengthPosition = currentLengthPosition
		this.currentWidthPosition = currentWidthPosition
		this.length = length
		this.width = width
		shape = new boolean[length][width]
		shape = [[true, true, true, true], [false, false, false, false],
		         [false, false, false, false], [false, false, false, false]]
	}




}