
class JPiece extends TetrisPiece {

	JPiece(def currentLengthPosition, def currentWidthPosition, def length = 3, def width = 3) {
		this.currentLengthPosition = currentLengthPosition
		this.currentWidthPosition = currentWidthPosition
		this.length = length
		this.width = width
		shape = new int[length][width]
		shape = [[1, 0, 0], [1, 1, 1], [0, 0, 0]]
	}

}
