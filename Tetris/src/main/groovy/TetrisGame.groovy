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
		if(!isGameOver()) {
			fall()
		}
	}

	private void fall() {
		filledBoardCells[filledLevel][0] = true
		filledLevel++
	}


	def isGameOver() {
		return filledLevel >= boardLength
	}

	def playGame() {
		while (!isGameOver()) {
			blockFalls()
		}
	}

	def canFall() {
		currentLengthPosition > filledLevel
	}

	def fallsOneCell() {
		if(canFall()) {
			markCurrentPositionAsUnfilled()
			currentLengthPosition --;
			filledBoardCells[currentLengthPosition][0] = true
			if(currentLengthPosition == filledLevel+1) {
				filledLevel ++
			}
		}


	}

	private void markCurrentPositionAsUnfilled() {
		if (currentLengthPosition < boardLength) {
			filledBoardCells[currentLengthPosition][0] = false
		}
	}


}
