class TetrisGame {

	TetrisPiece tetrisPiece
	TetrisBoard tetrisBoard



	TetrisGame(def boardLength, def boardWidth) {
		tetrisBoard = new TetrisBoard(boardLength, boardWidth)
		tetrisPiece = new TetrisPiece(boardLength, boardWidth/2)
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
		tetrisPiece.currentLengthPosition = tetrisBoard.boardLength
	}



	def isGameOver() {
		return tetrisBoard.boardIsFilled()
	}

	def playGame() {
		while (!isGameOver()) {
			blockFalls()
		}
	}


	def fallsOneCell() {
		if(canFall()) {
			if (tetrisPiece.currentLengthPosition < tetrisBoard.boardLength) {
				markCurrentPositionAsUnfilled()
			}
			tetrisPiece.currentLengthPosition --;
			markCurrentPositionAsFilled()
			if(tetrisPiece.currentLengthPosition == tetrisBoard.filledLevel) {
				tetrisBoard.filledLevel ++
			}
		}


	}

	private def canFall() {
		tetrisPiece.currentLengthPosition > tetrisBoard.filledLevel
	}

	private void markCurrentPositionAsUnfilled() {
		tetrisBoard.filledBoardCells[tetrisPiece.currentLengthPosition][tetrisPiece.currentWidthPosition] = false
	}

	private void markCurrentPositionAsFilled() {
		tetrisBoard.filledBoardCells[tetrisPiece.currentLengthPosition][tetrisPiece.currentWidthPosition] = true
	}

	def isCellFromGivenPositionFilled(int givenLength, int givenWidth) {
		return tetrisBoard.filledBoardCells[givenLength][givenWidth]
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
		tetrisPiece.currentWidthPosition <  tetrisBoard.boardLength-1
	}



	def markBoardCellAsFilled(int length, int width) {
		tetrisBoard.filledBoardCells[length][width] = true
	}

	def markBoardCellAsUnFilled(int length, int width) {
		tetrisBoard.filledBoardCells[length][width] = false
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
