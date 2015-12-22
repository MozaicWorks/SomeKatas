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
			markCurrentPositionAsFilled()
			if(currentLengthPosition == filledLevel) {
				filledLevel ++
			}
		}


	}

	private def canFall() {
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

	private boolean canMoveLeft() {
		currentWidthPosition > 0
	}

	def moveBlockToRight() {
		if(canMoveRight()) {
			markCurrentPositionAsUnfilled()
			currentWidthPosition++
			markCurrentPositionAsFilled()
		}
	}

	private boolean canMoveRight() {
		currentWidthPosition <  boardLength-1
	}



	def markBoardCellAsFilled(int length, int width) {
		filledBoardCells[length][width] = true
	}

	def markBoardCellAsUnFilled(int length, int width) {
		filledBoardCells[length][width] = false
	}

	def initializeIPiece() {
		currentLengthPosition --
		markBoardCellAsFilled(currentLengthPosition, currentWidthPosition-1)
		markBoardCellAsFilled(currentLengthPosition, currentWidthPosition)
		markBoardCellAsFilled(currentLengthPosition, currentWidthPosition+1)
		markBoardCellAsFilled(currentLengthPosition, currentWidthPosition+2)
	}

	def initializeJPiece() {
		currentLengthPosition --
		markBoardCellAsFilled(currentLengthPosition, currentWidthPosition-1)
		markBoardCellAsFilled(currentLengthPosition, currentWidthPosition)
		markBoardCellAsFilled(currentLengthPosition, currentWidthPosition+1)
		markBoardCellAsFilled(currentLengthPosition-1, currentWidthPosition+1)


	}
}
