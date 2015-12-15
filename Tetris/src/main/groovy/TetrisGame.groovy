class TetrisGame {
	boolean[][] filledGameCells
	int boardWidth
	int boardLength

	TetrisGame(def boardWidth, def boardLength) {
		this.boardWidth = boardWidth
		this.boardLength = boardLength
		filledGameCells = new boolean[boardWidth][boardLength]

	}

	def fillBoardGame() {
		filledGameCells[0][0] = true
	}

	def isGameOver() {
		return filledGameCells[0][boardLength-1]

	}

}
