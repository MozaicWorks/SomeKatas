class TetrisGame {
	boolean[][] filledBoardCells
	int filledLevel
	
	TetrisPiece tetrisPiece


	int boardWidth
	int boardLength

	TetrisGame(def boardLength, def boardWidth) {
		this.boardWidth = boardWidth
		this.boardLength = boardLength
		tetrisPiece = new TetrisPiece()
		filledBoardCells = new boolean[boardLength][boardWidth]
		tetrisPiece.currentLengthPosition = boardLength
		tetrisPiece.currentWidthPosition = boardWidth/2
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
		tetrisPiece.currentLengthPosition = boardLength
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
			if (tetrisPiece.currentLengthPosition < boardLength) {
				markCurrentPositionAsUnfilled()
			}
			tetrisPiece.currentLengthPosition --;
			markCurrentPositionAsFilled()
			if(tetrisPiece.currentLengthPosition == filledLevel) {
				filledLevel ++
			}
		}


	}

	private def canFall() {
		tetrisPiece.currentLengthPosition > filledLevel
	}

	private void markCurrentPositionAsUnfilled() {
		filledBoardCells[tetrisPiece.currentLengthPosition][tetrisPiece.currentWidthPosition] = false
	}

	private void markCurrentPositionAsFilled() {
		filledBoardCells[tetrisPiece.currentLengthPosition][tetrisPiece.currentWidthPosition] = true
	}

	def isCellFromGivenPositionFilled(int givenLength, int givenWidth) {
		return filledBoardCells[givenLength][givenWidth]
	}

	def moveBlockToLeft() {
		if(canMoveLeft()) {
			markCurrentPositionAsUnfilled()
			tetrisPiece.currentWidthPosition--
			markCurrentPositionAsFilled()
		}
	}

	private boolean canMoveLeft() {
		tetrisPiece.currentWidthPosition > 0
	}

	def moveBlockToRight() {
		if(canMoveRight()) {
			markCurrentPositionAsUnfilled()
			tetrisPiece.currentWidthPosition++
			markCurrentPositionAsFilled()
		}
	}

	private boolean canMoveRight() {
		tetrisPiece.currentWidthPosition <  boardLength-1
	}



	def markBoardCellAsFilled(int length, int width) {
		filledBoardCells[length][width] = true
	}

	def markBoardCellAsUnFilled(int length, int width) {
		filledBoardCells[length][width] = false
	}

	def initializeIPiece() {
		tetrisPiece.currentLengthPosition --
		markBoardCellAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition-1)
		markBoardCellAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition)
		markBoardCellAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition+1)
		markBoardCellAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition+2)
	}

	def initializeJPiece() {
		tetrisPiece.currentLengthPosition --
		markBoardCellAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition-1)
		markBoardCellAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition)
		markBoardCellAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition+1)
		markBoardCellAsFilled(tetrisPiece.currentLengthPosition-1, tetrisPiece.currentWidthPosition+1)


	}
}
