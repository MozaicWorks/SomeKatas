class TetrisGame {
	boolean[][] filledBoardCells
	int filledLevel
	int currentLengthPosition

	int boardWidth
	int boardLength

	TetrisGame(def boardLength, def boardWidth) {
		this.boardWidth = boardWidth
		this.boardLength = boardLength
		filledBoardCells = new boolean[boardLength][boardWidth]
		currentLengthPosition = boardLength
	}


	def blockFalls() {
		if(canFall()) {
			fall()
		}
	}

	private void fall() {
		filledBoardCells[filledLevel][0] = true
		filledLevel++
	}

	private boolean canFall() {
		filledLevel <= boardLength
	}

	def isGameOver() {
		return filledLevel >= boardLength
	}

	def playGame() {
		while (!isGameOver()) {
			blockFalls()
		}
	}

	def fallsOneCell() {
		currentLengthPosition --;
		filledBoardCells[currentLengthPosition][0] = true
		filledLevel++
	}


}
