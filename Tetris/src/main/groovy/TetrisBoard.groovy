class TetrisBoard {

	int boardWidth
	int boardLength

	int[][] filledBoardCells
	int filledLevel


	TetrisBoard(def boardLength, def boardWidth) {
		this.boardLength = boardLength
		this.boardWidth = boardWidth
		filledBoardCells = new int[boardLength][boardWidth]
	}



	def boardIsFilled() {
		return filledLevel >= boardLength
	}



	def markPositionAsFilled(int length, int width) {
		filledBoardCells[length][width] = 1
	}


	def markPositionAsUnFilled(int length, int width) {
		filledBoardCells[length][width] = 0
	}

}
