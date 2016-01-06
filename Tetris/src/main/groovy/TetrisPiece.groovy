
class TetrisPiece {

	int currentLengthPosition
	int currentWidthPosition
	int length
	int width
	int[][] shape

	TetrisPiece() {

	}

	TetrisPiece(def currentLengthPosition, def currentWidthPosition, def length = 1, def width = 1) {
		this.currentLengthPosition = currentLengthPosition
		this.currentWidthPosition = currentWidthPosition
		this.length = length
		this.width = width
		shape = new int[length][width]
		shape = 1
	}






}
