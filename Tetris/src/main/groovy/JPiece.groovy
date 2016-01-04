
class JPiece extends TetrisPiece {

	JPiece(def currentLengthPosition, def currentWidthPosition, def length = 4, def width = 4) {
		this.currentLengthPosition = currentLengthPosition
		this.currentWidthPosition = currentWidthPosition
		this.length = length
		this.width = width
		shape = new boolean[length][width]
		shape = [[true, false, false, false], [true, true, true, false],
		         [false, false, false, false], [false, false, false, false]]
	}

}
