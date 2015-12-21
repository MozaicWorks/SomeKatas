class TetrisGame {
	boolean[][] filledBoardCells
	int filledLevel

	int currentLengthPosition
	int currentWidthPosition

	int boardWidth
	int boardLength

	TetrisGame(def boardLength, def boardWidth) {
		this.boardWidth = boardWidth
		this.boardLength = boardLength
		filledBoardCells = new boolean[boardLength][boardWidth]
		currentLengthPosition = boardLength
		currentWidthPosition = boardWidth/2
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
			if (currentLengthPosition < boardLength) {
				markCurrentPositionAsUnfilled()
			}
			currentLengthPosition --;
			filledBoardCells[currentLengthPosition][currentWidthPosition] = true
			if(currentLengthPosition == filledLevel) {
				filledLevel ++
			}
		}


	}

	def canFall() {
		currentLengthPosition > filledLevel
	}

	private void markCurrentPositionAsUnfilled() {
		filledBoardCells[currentLengthPosition][currentWidthPosition] = false
	}

	private void markCurrentPositionAsFilled() {
		filledBoardCells[currentLengthPosition][currentWidthPosition] = true
	}

	def isCellFromGivenPositionFilled(int givenLength, int givenWidth) {
		return filledBoardCells[givenLength][givenWidth]
	}

	def moveBlockToLeft() {
		if(canMoveLeft()) {
			markCurrentPositionAsUnfilled()
			currentWidthPosition--
			markCurrentPositionAsFilled()
		}
	}

	boolean canMoveLeft() {
		currentWidthPosition >= 1
	}

	def moveBlockToRight() {
		if(canMoveRight()) {
			markCurrentPositionAsUnfilled()
			currentWidthPosition++
			markCurrentPositionAsFilled()
		}

	}

	boolean canMoveRight() {
		currentWidthPosition <  boardLength-1
	}
}
