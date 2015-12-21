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
			resetCurrentPosition()
			while (canFall()) {
				fallsOneCell()
			}
		}
	}

	def resetCurrentPosition() {
		currentLengthPosition = boardLength
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
		if(canFall()) {
			markCurrentPositionAsUnfilled()
			currentLengthPosition --;
			filledBoardCells[currentLengthPosition][0] = true
			if(currentLengthPosition == filledLevel) {
				filledLevel ++
			}
		}


	}

	def canFall() {
		currentLengthPosition > filledLevel
	}

	private void markCurrentPositionAsUnfilled() {
		if (currentLengthPosition < boardLength) {
			filledBoardCells[currentLengthPosition][0] = false
		}
	}


}
