class TetrisGame {
	boolean[][] filledGameCells
	int boardWidth
	int boardLength
	int currentLevel


	TetrisGame(def boardWidth, def boardLength) {
		this.boardWidth = boardWidth
		this.boardLength = boardLength
		filledGameCells = new boolean[boardWidth][boardLength]
	}

	def blockFalls() {
		if(currentLevel <= boardLength - 1) {
			filledGameCells[0][currentLevel] = true
			currentLevel++
		}
	}

	def isGameOver() {
		return currentLevel >= boardLength
	}

	def playGame() {
		while (!isGameOver()) {
			blockFalls()
		}
	}








}
