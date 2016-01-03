
class TetrisPiece {

	int currentLengthPosition
	int currentWidthPosition
	int length
	int width
	boolean[][] shape

	TetrisPiece(def currentLengthPosition, def currentWidthPosition, def length = 1, def width = 1) {
		this.currentLengthPosition = currentLengthPosition
		this.currentWidthPosition = currentWidthPosition
		this.length = length
		this.width = width
		shape = new boolean[length][width]
	}

	def initializeIShape() {
		length = 4
		width = 4
		shape = [[true, true, true, true], [false, false, false, false],
		         [false, false, false, false], [false, false, false, false]]
	}
}
