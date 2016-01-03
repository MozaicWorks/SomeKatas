class TetrisBoard {


	int boardWidth
	int boardLength

	boolean[][] filledBoardCells
	int filledLevel

	TetrisBoard(def boardLength, def boardWidth) {
		this.boardLength = boardLength
		this.boardWidth = boardWidth
		filledBoardCells = new boolean[boardLength][boardWidth]
	}

	def boardIsFilled() {
		return filledLevel >= boardLength
	}


}
