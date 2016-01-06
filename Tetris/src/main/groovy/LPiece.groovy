class LPiece extends TetrisPiece {

	LPiece(def currentLengthPosition, def currentWidthPosition, def length = 4, def width = 4) {
		this.currentLengthPosition = currentLengthPosition
		this.currentWidthPosition = currentWidthPosition
		this.length = length
		this.width = width
		shape = new int[length][width]
		shape = [[1, 1, 1, 1], [0, 0, 0, 0],
		         [0, 0, 0, 0], [0, 0, 0, 0]]
	}
}
