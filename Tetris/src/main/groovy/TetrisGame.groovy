class TetrisGame {
	boolean[][] filledBoardCells
	int filledLevel

	int boardWidth
	int boardHeight

	TetrisGame(def boardWidth, def boardHeight) {
		this.boardWidth = boardWidth
		this.boardHeight = boardHeight
		filledBoardCells = new boolean[boardWidth][boardHeight]
	}

	def blockFalls() {
		if(canFall()) {
			fall()
		}
	}

	private void fall() {
		filledBoardCells[0][filledLevel] = true
		filledLevel++
	}

	private boolean canFall() {
		filledLevel <= boardHeight
	}

	def isGameOver() {
		return filledLevel >= boardHeight
	}

	def playGame() {
		while (!isGameOver()) {
			blockFalls()
		}
	}
}
